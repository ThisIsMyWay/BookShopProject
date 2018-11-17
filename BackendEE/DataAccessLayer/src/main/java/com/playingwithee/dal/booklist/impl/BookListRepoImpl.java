package com.playingwithee.dal.booklist.impl;


import com.playingwithee.dal.booklist.api.BookListRepo;
import com.playingwithee.dal.booklist.api.dto.BookOverallData;
import com.playingwithee.dal.entities.Book;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Stateful
public class BookListRepoImpl implements BookListRepo {

    @PersistenceContext(unitName = "bookShopDB")
    private EntityManager entityManager;

    @Override
    public Set<BookOverallData> getAllBooks() {
        System.out.println("book list called");
        Query query = entityManager.createQuery("SELECT b from Book as b");
        List<Book> ersultList = query.getResultList();
        return null;
    }
}
