package com.playingwithee.dal.author.api;

import com.playingwithee.dal.author.api.dto.AuthorData;

import java.util.Optional;

public interface AuthorRepo {

    public Optional<AuthorData> getAuthor(Long id);
}
