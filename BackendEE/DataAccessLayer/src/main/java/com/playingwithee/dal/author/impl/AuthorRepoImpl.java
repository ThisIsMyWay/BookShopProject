package com.playingwithee.dal.author.impl;

import com.playingwithee.dal.author.api.AuthorRepo;
import com.playingwithee.dal.author.api.dto.AuthorData;
import com.playingwithee.dal.author.api.dto.BookOfAuthor;
import com.playingwithee.dal.entities.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class AuthorRepoImpl implements AuthorRepo {

    @PersistenceContext(unitName = "bookShopDB")
    private transient EntityManager entityManager;

    @Override
    public Optional<AuthorData> getAuthor(Long id) {
        final Author authorEntity = entityManager.find(Author.class, id);
        return Optional.ofNullable(authorEntity)
                .map(p -> new AuthorData(p.getAuthorId(),
                        p.getName(),
                        p.getSurname(),
                        p.getBirthDate(),
                        p.getDeathDate(),
                        p.getBookList().stream().map(b -> new BookOfAuthor(b.getBookId(),
                                b.getTitle())).collect(Collectors.toSet())));
    }
}
