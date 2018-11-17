package com.playingwithee.dal.booklist.impl;


import com.playingwithee.dal.booklist.api.BookListRepo;
import com.playingwithee.dal.booklist.api.dto.BookOverallData;

import javax.ejb.Stateful;
import java.util.Set;

@Stateful
public class BookListRepoImpl implements BookListRepo {


    @Override
    public Set<BookOverallData> getAllBooks() {
        System.out.println("book list called");

        return null;
    }
}
