package com.playingwithee.restapi.books;


import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.books.converter.BookDataObjectsToViewModelConverter;
import com.playingwithee.restapi.books.viewmodels.BookDetailsVM;
import com.playingwithee.restapi.books.viewmodels.BookListItemVM;
import com.playingwithee.service.books.BooksService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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

    @Path("")
    @GET
    public Response getBookList(){
        final Set<BookOverallData> listOfBooks = booksService.getListOfBooks();
        final Set<BookListItemVM> itemsForResponse = BookDataObjectsToViewModelConverter.convert(listOfBooks);
        return Response.ok(itemsForResponse).build();
    }


    @Path("/{bookId}")
    @GET
    public Response getBookDetails(@PathParam(value= "bookId")Long id) {
        final Optional<BookDetailsData> bookDetails = booksService.getBookDetails(id);
        final Optional<BookDetailsVM> itemForResponse = BookDataObjectsToViewModelConverter.convert(bookDetails);
        if (itemForResponse.isPresent()){
            return Response.ok(itemForResponse.get()).build();
        }
        return Response.noContent().build();
    }
}
