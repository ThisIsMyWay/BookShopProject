package com.playingwithee.restapi.books;


import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.authors.AuthorsResource;
import com.playingwithee.restapi.books.converter.BookDataObjectsToViewModelConverter;
import com.playingwithee.restapi.books.viewmodels.BookDetailsVM;
import com.playingwithee.restapi.books.viewmodels.BookListItemVM;
import com.playingwithee.restapi.books.viewmodels.BookListVM;
import com.playingwithee.restapi.hateoas.HateoasLinkGenerator;
import com.playingwithee.service.books.BooksService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

@RequestScoped
@Consumes({"application/json"})
@Produces({"application/json"})
@Path("/books")
public class BooksResource implements Serializable {


    @EJB
    private BooksService booksService;

    @Context
    private UriInfo uriInfo;

    private HateoasLinkGenerator hateoasLinkGenerator;

    @PostConstruct
    public void init(){
        hateoasLinkGenerator = new HateoasLinkGenerator(uriInfo);
    }

    @Path("")
    @GET
    public Response getBookList(){

        final Set<BookOverallData> listOfBooks = booksService.getListOfBooks();
        final Set<BookListItemVM> itemsForResponse = BookDataObjectsToViewModelConverter.convert(listOfBooks);

        itemsForResponse.forEach( a -> {
            a.getLinks().add(hateoasLinkGenerator.generate("book_details", BooksResource.class, "getBookDetails", a.getIdOfBook()));
        });

        BookListVM bookListVM = new BookListVM();
        bookListVM.getBookList().addAll(itemsForResponse);
        bookListVM.getLinks().add(hateoasLinkGenerator.generate("self", BooksResource.class, "getBookList"));

        return Response.ok(bookListVM).build();
    }


    @Path("/{bookId}")
    @GET
    public Response getBookDetails(@PathParam(value= "bookId")Long id) {
        final Optional<BookDetailsData> bookDetails = booksService.getBookDetails(id);
        final Optional<BookDetailsVM> itemForResponse = BookDataObjectsToViewModelConverter.convert(bookDetails);
        if (itemForResponse.isPresent()){
            final BookDetailsVM bookDetailsVM = itemForResponse.get();
            bookDetailsVM.getLinks().add(hateoasLinkGenerator.generate("self", BooksResource.class,"getBookDetails", id));
            bookDetailsVM.getLinks().add(hateoasLinkGenerator.generate("book_list", BooksResource.class, "getBookList"));
            bookDetailsVM.getAuthorsOfBook().forEach( a -> {
                a.getLinks().add(hateoasLinkGenerator.generate("author_details", AuthorsResource.class,
                        "getAuthorDetails", a.getAuthorId()));
            });
            return Response.ok(bookDetailsVM).build();
        }
        return Response.noContent().build();
    }




}
