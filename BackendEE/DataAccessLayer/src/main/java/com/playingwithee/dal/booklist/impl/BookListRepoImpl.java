package com.playingwithee.dal.booklist.impl;


import com.playingwithee.dal.booklist.api.BookListRepo;
import com.playingwithee.dal.booklist.api.dto.BookOverallData;
import com.playingwithee.dal.entities.Book;
import com.playingwithee.dal.entities.Discount;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateful
public class BookListRepoImpl implements BookListRepo {

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
                        p.getAuthorList().stream().map(author -> author.getName() + " " + author.getSurname()).collect(Collectors.joining()),
                        p.getBasePrice(),
                        p.getDiscountList().stream().map(Discount::getPercentageDiscount).reduce(0, Integer::sum)))
                .collect(Collectors.toSet());
    }
}
