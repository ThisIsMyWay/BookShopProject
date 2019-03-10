package com.playingwithee.restapi.authors;

import com.playingwithee.dal.author.api.dto.AuthorData;
import com.playingwithee.restapi.authors.converter.AuthorDataObjectsToViewModelConverter;
import com.playingwithee.restapi.authors.hateoas.AuthorResourceHateoasAdder;
import com.playingwithee.restapi.authors.viewmodels.AuthorVM;
import com.playingwithee.service.authors.AuthorsService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Optional;

@RequestScoped
@Path("/authors")
@Consumes({"application/json"})
@Produces({"application/json"})
public class AuthorsResource {

    @EJB
    private AuthorsService authorsService;

    @Context
    private UriInfo uriInfo;

    private AuthorResourceHateoasAdder hateoasAdder;

    @PostConstruct
    public void init(){
        hateoasAdder = new AuthorResourceHateoasAdder(uriInfo);
    }


    @GET
    @Path("/{authorId}")
    public Response getAuthorDetails(@PathParam(value= "authorId")Long authorId){
        final Optional<AuthorData> author = authorsService.getAuthor(authorId);
        final Optional<AuthorVM> authorVM = AuthorDataObjectsToViewModelConverter.convert(author);
        if (authorVM.isPresent()){
            final AuthorVM authorVMUnboxed = authorVM.get();
            hateoasAdder.setLinks(authorVMUnboxed);
            return Response.ok(authorVMUnboxed).build();
        }
        return Response.noContent().build();
    }
}
