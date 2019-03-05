package com.playingwithee.restapi.hateoas;

import java.util.ArrayList;
import java.util.List;


public class HateoasSupportingVM {

    private List<CustomLink> links;

    public List<CustomLink> getLinks() {
        if (links == null){
            links = new ArrayList<>();
        }
        return links;
    }
}
