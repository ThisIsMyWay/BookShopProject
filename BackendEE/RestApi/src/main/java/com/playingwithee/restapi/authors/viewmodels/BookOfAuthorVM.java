package com.playingwithee.restapi.authors.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookOfAuthorVM extends HateoasSupportingVM {

    private Long id;

    private String title;
}
