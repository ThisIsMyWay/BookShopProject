package com.playingwithee.dal.author.impl;

import com.playingwithee.dal.author.api.AuthorRepo;
import com.playingwithee.dal.author.api.dto.AuthorData;
import com.playingwithee.dal.author.api.dto.BookOfAuthor;
import com.playingwithee.dal.entities.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class AuthorRepoImpl implements AuthorRepo {

    @PersistenceContext(unitName = "bookShopDB")
    private transient EntityManager entityManager;

    @Override
    public Optional<AuthorData> getAuthor(Long id) {
        final Query queryForAllAuthors = entityManager.createNamedQuery("Author.getWithBooks");
        queryForAllAuthors.setParameter("id", id);
        final List<Author> authors = queryForAllAuthors.getResultList();
        return authors.stream().findFirst()
                .map(p -> new AuthorData(p.getId(),
                p.getName(),
                p.getSurname(),
                p.getBirthDate(),
                p.getDeathDate(),
                p.getBookList().stream().map(b -> new BookOfAuthor(b.getId(),
                        b.getTitle())).collect(Collectors.toSet())));
    }
}
