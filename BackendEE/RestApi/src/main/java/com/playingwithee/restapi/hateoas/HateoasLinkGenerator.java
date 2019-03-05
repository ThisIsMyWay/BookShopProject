package com.playingwithee.restapi.hateoas;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;

public class HateoasLinkGenerator {

    private UriInfo uriInfo;

    public HateoasLinkGenerator(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    public CustomLink generate(String linkName, Class classToWhichMethodBelongs, String nameOfMethod, Object...params) {
        final UriBuilder methodUriBuilder = UriBuilder.fromResource(classToWhichMethodBelongs).path(classToWhichMethodBelongs, nameOfMethod);
        final URI uriOfMethod = methodUriBuilder.build(params);
        final URI baseUri = uriInfo.getBaseUri();
        final URI resolve = baseUri.resolve(baseUri.getPath() + uriOfMethod.getPath()).normalize();


        String typeOfMethod = null;
        for (Method method : classToWhichMethodBelongs.getMethods()) {
            if (method.getName().equals(nameOfMethod)){
                for (Annotation annotation : method.getAnnotations()){
                    final Class<? extends Annotation> aClass = annotation.annotationType();

                    switch(aClass.getName()) {
                        case "javax.ws.rs.DELETE":
                        case "javax.ws.rs.GET":
                        case "javax.ws.rs.HEAD":
                        case "javax.ws.rs.OPTIONS":
                        case "javax.ws.rs.PATCH":
                        case "javax.ws.rs.POST":
                        case "javax.ws.rs.PUT":
                            final String nameOfClass = aClass.getName();
                            typeOfMethod = nameOfClass.substring(nameOfClass.lastIndexOf('.') + 1);
                            break;
                    }

                }

            }
        }


        return new CustomLink(resolve.toString(), linkName, typeOfMethod);
    }
}
