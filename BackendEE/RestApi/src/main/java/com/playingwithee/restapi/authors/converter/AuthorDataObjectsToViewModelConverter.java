package com.playingwithee.restapi.authors.converter;

import com.playingwithee.dal.author.api.dto.AuthorData;
import com.playingwithee.restapi.authors.viewmodels.AuthorVM;
import com.playingwithee.restapi.authors.viewmodels.BookOfAuthorVM;

import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorDataObjectsToViewModelConverter {

    public static Optional<AuthorVM> convert(Optional<AuthorData> authorData){
        return authorData.map( a -> new AuthorVM(a.getAuthorId(),
                a.getName(),
                a.getSurname(),
                a.getBirthDate(),
                a.getDeathDate(),
                a.getBooksOfAuthor().stream().map(b -> new BookOfAuthorVM(b.getId(), b.getTitle())).collect(Collectors.toSet())));
    }
}
