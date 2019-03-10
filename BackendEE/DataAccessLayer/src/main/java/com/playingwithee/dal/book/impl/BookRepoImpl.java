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
    public Set<BookOverallData> getAllBooks() {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findAll", Book.class);
        List<Book> booksList = query.getResultList();
        return booksList.stream()
                .map(p -> new BookOverallData(
                        p.getBookId(),
                        p.getTitle(),
                        p.getAuthorList().stream().map(author -> author.getName() + " " + author.getSurname()).collect(Collectors.joining(", ")),
                        p.getAuthorList().stream().map(author -> new AuthorOfBook(author.getAuthorId(),author.getName() + " " + author.getSurname())).collect(Collectors.toSet()),
                        p.getBasePrice(),
                        p.getDiscountList().stream().map(Discount::getRate).reduce(0, Integer::sum)))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<BookDetailsData> getBookDetailsById(Long id) {
        final Book reference = entityManager.find(Book.class, id);
        return Optional.ofNullable(reference)
                .map(p -> new BookDetailsData(p.getBookId(),
                        p.getTitle(),
                        p.getIsbn(),
                        p.getDescription(),
                        p.getPublishingDate(),
                        p.getBasePrice(),
                        p.getAuthorList().stream().map(author -> new AuthorOfBook(author.getAuthorId(),author.getName() + " " + author.getSurname())).collect(Collectors.toSet()),
                        p.getDiscountList().stream().map(discount -> new DiscountDetatilsData(discount.getDiscountId(),
                                discount.getName(),
                                discount.getRate())).collect(Collectors.toSet())));
    }

}
