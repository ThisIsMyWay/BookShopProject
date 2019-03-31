package com.playingwithee.dal.book.impl;


import com.playingwithee.dal.book.api.BookRepo;
import com.playingwithee.dal.book.api.dto.AuthorOfBook;
import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.dal.book.api.dto.DiscountDetatilsData;
import com.playingwithee.dal.entities.Book;
import com.playingwithee.dal.entities.Discount;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class BookRepoImpl implements BookRepo {

    @PersistenceContext(unitName = "bookShopDB")
    private transient EntityManager entityManager;

    @Override
    public Set<BookOverallData> getAllWithDiscountsAndAuthors() {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.getAllWithDiscountsAndAuthors", Book.class);
        List<Book> booksList = query.getResultList();
        return booksList.stream()
                .map(p -> new BookOverallData(
                        p.getId(),
                        p.getTitle(),
                        p.getAuthorList().stream().map(author -> author.getName() + " " + author.getSurname()).collect(Collectors.joining(", ")),
                        p.getAuthorList().stream().map(author -> new AuthorOfBook(author.getId(),author.getName() + " " + author.getSurname())).collect(Collectors.toSet()),
                        p.getBasePrice(),
                        p.getDiscountList().stream().map(Discount::getRate).reduce(0, Integer::sum)))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<BookDetailsData> getBookDetailsById(Long id) {

        final Query queryforParticularBook = entityManager.createNamedQuery("Book.getOneBookWithDiscountsAndAuthors");
        queryforParticularBook.setParameter("id", id);
        final List<Book> bookResultList = queryforParticularBook.getResultList();
        return bookResultList.stream().findFirst()
                .map(p -> new BookDetailsData(p.getId(),
                        p.getTitle(),
                        p.getIsbn(),
                        p.getDescription(),
                        p.getPublishingDate(),
                        p.getBasePrice(),
                        p.getAuthorList().stream().map(author -> new AuthorOfBook(author.getId(),author.getName() + " " + author.getSurname())).collect(Collectors.toSet()),
                        p.getDiscountList().stream().map(discount -> new DiscountDetatilsData(discount.getId(),
                                discount.getName(),
                                discount.getRate())).collect(Collectors.toSet())));
    }

}
