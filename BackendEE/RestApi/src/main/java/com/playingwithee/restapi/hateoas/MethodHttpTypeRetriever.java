package com.playingwithee.restapi.hateoas;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.Set;

class MethodHttpTypeRetriever {

    private static final Set<String> httpMethodsClasses = Set.of("javax.ws.rs.DELETE",
                                                                 "javax.ws.rs.GET",
                                                                 "javax.ws.rs.HEAD",
                                                                 "javax.ws.rs.OPTIONS",
                                                                 "javax.ws.rs.PATCH",
                                                                 "javax.ws.rs.POST",
                                                                 "javax.ws.rs.PUT");

    private MethodHttpTypeRetriever() {
    }

    public static String get(Class classToWhichMethodBelongs, String nameOfMethod) {
        return Arrays.stream(classToWhichMethodBelongs.getMethods())
                .filter(methodFromClass -> methodFromClass.getName().equals(nameOfMethod))
                .map(AccessibleObject::getAnnotations)
                .flatMap(Arrays::stream)
                .map(annotation -> annotation.annotationType().getName())
                .filter(httpMethodsClasses::contains)
                .map(nameOfClass ->  nameOfClass.substring(nameOfClass.lastIndexOf('.') +1))
                .findFirst().orElse("UNKNOWN");
    }
}