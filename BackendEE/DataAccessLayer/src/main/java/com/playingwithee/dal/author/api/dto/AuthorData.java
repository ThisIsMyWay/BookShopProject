package com.playingwithee.dal.author.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
public class AuthorData {

    private Long authorId;

    private String name;

    private String surname;

    private Date birthDate;

    private Date deathDate;

    private Set<BookOfAuthor> booksOfAuthor;

}
