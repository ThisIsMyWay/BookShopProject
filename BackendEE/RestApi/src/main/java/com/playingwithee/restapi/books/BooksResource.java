package com.playingwithee.restapi.books;


import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.books.converter.BookDataObjectsToViewModelConverter;
import com.playingwithee.restapi.books.hateoas.BookResourceHateoasAdder;
import com.playingwithee.restapi.books.viewmodels.BookDetailsVM;
import com.playingwithee.restapi.books.viewmodels.BookListVM;
import com.playingwithee.service.books.BooksService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Optional;
import java.util.Set;

@RequestScoped
@Consumes({"application/json"})
@Produces({"application/json"})
@Path("/books")
public class BooksResource {


    @EJB
    private BooksService booksService;

    @Context
    private UriInfo uriInfo;

    private BookResourceHateoasAdder hateoasAdder;

    @PostConstruct
    public void init(){
        hateoasAdder = new BookResourceHateoasAdder(uriInfo);
    }

    @Path("")
    @GET
    public Response getBookList(){
        final Set<BookOverallData> listOfBooks = booksService.getListOfBooks();
        final BookListVM bookListVM = BookDataObjectsToViewModelConverter.convert(listOfBooks);
        hateoasAdder.setLinks(bookListVM);
        return Response.ok(bookListVM).build();
    }


    @Path("/{bookId}")
    @GET
    public Response getBookDetails(@PathParam(value= "bookId")Long id) {
        final Optional<BookDetailsData> bookDetails = booksService.getBookDetails(id);
        final Optional<BookDetailsVM> itemForResponse = BookDataObjectsToViewModelConverter.convert(bookDetails);
        if (itemForResponse.isPresent()){
            final BookDetailsVM bookDetailsVM = itemForResponse.get();
            hateoasAdder.setLinks(bookDetailsVM);
            return Response.ok(bookDetailsVM).build();
        }
        return Response.noContent().build();
    }




}
