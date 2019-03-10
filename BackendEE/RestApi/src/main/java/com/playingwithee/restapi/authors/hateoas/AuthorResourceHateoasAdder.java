package com.playingwithee.restapi.authors.hateoas;

import com.playingwithee.restapi.authors.AuthorsResource;
import com.playingwithee.restapi.authors.viewmodels.AuthorVM;
import com.playingwithee.restapi.books.BooksResource;
import com.playingwithee.restapi.hateoas.HateoasLinkGenerator;

import javax.ws.rs.core.UriInfo;

public class AuthorResourceHateoasAdder {

    private HateoasLinkGenerator hateoasLinkGenerator;

    public AuthorResourceHateoasAdder(UriInfo uriInfo) {
        this.hateoasLinkGenerator = new HateoasLinkGenerator(uriInfo);
    }

    public void setLinks(AuthorVM authorVM){
        authorVM.getLinks().add(hateoasLinkGenerator.generate("self", AuthorsResource.class, "getAuthorDetails", authorVM.getAuthorId()));

        authorVM.getBooksOfAuthor().forEach( book ->
                book.getLinks().add(hateoasLinkGenerator.generate("book_details", BooksResource.class, "getBookDetails", book.getId()))
        );
    }
}
