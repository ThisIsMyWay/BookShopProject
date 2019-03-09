package com.playingwithee.restapi.hateoas;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class HateoasLinkGenerator {

    private UriInfo uriInfo;

    public HateoasLinkGenerator(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    public CustomLink generate(String linkName, Class classToWhichMethodBelongs, String nameOfMethod, Object...params) {
        final URI finalUriToMethod = retrieveUriToMethod(classToWhichMethodBelongs, nameOfMethod, params);

        final String typeOfMethod = MethodHttpTypeRetriever.get(classToWhichMethodBelongs, nameOfMethod);
        return new CustomLink(finalUriToMethod.toString(), linkName, typeOfMethod);
    }

    private URI retrieveUriToMethod(Class classToWhichMethodBelongs, String nameOfMethod, Object[] params) {
        final UriBuilder methodUriBuilder = UriBuilder.fromResource(classToWhichMethodBelongs).path(classToWhichMethodBelongs, nameOfMethod);
        final URI uriOfMethod = methodUriBuilder.build(params);
        final URI baseUri = uriInfo.getBaseUri();
        return baseUri.resolve(baseUri.getPath() + uriOfMethod.getPath()).normalize();
    }

}
