package com.playingwithee.dal.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorOfBook {

    private Long authorId;

    private String name;
}
