package com.playingwithee.restapi.hateoas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class CustomLink {

    private String href;
    private String rel;
    private String method;

}
