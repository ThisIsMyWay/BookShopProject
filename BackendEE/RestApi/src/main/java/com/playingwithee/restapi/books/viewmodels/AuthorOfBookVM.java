package com.playingwithee.restapi.books.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthorOfBookVM {

    private Long authorId;

    private String name;
}
