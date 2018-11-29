package com.playingwithee.restapi.books;


import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.books.converter.BookObjectsConverter;
import com.playingwithee.restapi.books.presentationlayerobjects.BookListItem;
import com.playingwithee.service.books.BooksService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

@RequestScoped
@Consumes({"application/json"})
@Produces({"application/json"})
@Path("/books")
public class BooksResource {


    @EJB
    private BooksService booksService;

    @Path("")
    @GET
    public Response getBookList(){
        final Set<BookOverallData> listOfBooks = booksService.getListOfBooks();
        final Set<BookListItem> itemsForResponse = BookObjectsConverter.convert(listOfBooks);
        return Response.ok(itemsForResponse).build();
    }

}
