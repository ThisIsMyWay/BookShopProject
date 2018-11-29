package com.playingwithee.restapi.authors;

import com.playingwithee.dal.author.api.dto.AuthorData;
import com.playingwithee.restapi.authors.converter.AuthorDataObjectsToViewModelConverter;
import com.playingwithee.restapi.authors.viewmodels.AuthorVM;
import com.playingwithee.service.authors.AuthorsService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Optional;

@RequestScoped
@Path("/authors")
@Consumes({"application/json"})
@Produces({"application/json"})
public class AuthorsResource implements Serializable {

    @EJB
    private AuthorsService authorsService;

    @GET
    @Path("/{authorId}")
    public Response getAuthorDetails(@PathParam(value= "authorId")Long authorId){
        final Optional<AuthorData> author = authorsService.getAuthor(authorId);
        final Optional<AuthorVM> authorVM = AuthorDataObjectsToViewModelConverter.convert(author);
        if (authorVM.isPresent()){
            return Response.ok(authorVM.get()).build();
        }
        return Response.noContent().build();
    }
}
