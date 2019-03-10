package com.playingwithee.restapi.books.hateoas;

import com.playingwithee.restapi.authors.AuthorsResource;
import com.playingwithee.restapi.books.BooksResource;
import com.playingwithee.restapi.books.viewmodels.BookDetailsVM;
import com.playingwithee.restapi.books.viewmodels.BookListVM;
import com.playingwithee.restapi.hateoas.HateoasLinkGenerator;

import javax.ws.rs.core.UriInfo;

public class BookResourceHateoasAdder {

    private HateoasLinkGenerator hateoasLinkGenerator;

    public BookResourceHateoasAdder(UriInfo uriInfo) {
        this.hateoasLinkGenerator = new HateoasLinkGenerator(uriInfo);
    }

    public void setLinks(BookListVM bookListVM){
        bookListVM.getLinks().add(hateoasLinkGenerator.generate("self", BooksResource.class, "getBookList"));
        bookListVM.getBookList().forEach( a -> {
                    a.getLinks().add(hateoasLinkGenerator.generate("book_details", BooksResource.class, "getBookDetails", a.getIdOfBook()));
                    a.getAuthorsOfBook().forEach(author -> author.getLinks().add(hateoasLinkGenerator.generate("author_details", AuthorsResource.class, "getAuthorDetails", author.getAuthorId())));
                }
        );
    }


    public void setLinks(BookDetailsVM bookDetailsVM){
        bookDetailsVM.getLinks().add(hateoasLinkGenerator.generate("self", BooksResource.class,"getBookDetails", bookDetailsVM.getIdOfBook()));
        bookDetailsVM.getLinks().add(hateoasLinkGenerator.generate("book_list", BooksResource.class, "getBookList"));
        bookDetailsVM.getAuthorsOfBook().forEach( a -> {
            a.getLinks().add(hateoasLinkGenerator.generate("author_details", AuthorsResource.class,
                    "getAuthorDetails", a.getAuthorId()));
        });
    }
}
