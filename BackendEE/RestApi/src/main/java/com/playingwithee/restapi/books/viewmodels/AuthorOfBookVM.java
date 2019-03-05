package com.playingwithee.restapi.books.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthorOfBookVM extends HateoasSupportingVM {

    private Long authorId;

    private String name;
}
