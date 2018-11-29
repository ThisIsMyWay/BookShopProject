package com.playingwithee.service.authors;

import com.playingwithee.dal.author.api.AuthorRepo;
import com.playingwithee.dal.author.api.dto.AuthorData;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
public class AuthorsService {

    @EJB
    private AuthorRepo authorRepo;


    public Optional<AuthorData> getAuthor(Long id) {
        return authorRepo.getAuthor(id);
    }
}
