package com.playingwithee.restapi.authors.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
public class AuthorVM extends HateoasSupportingVM {

    private Long authorId;

    private String name;

    private String surname;

    private Date birthDate;

    private Date deathDate;

    private Set<BookOfAuthorVM> booksOfAuthor;

}
