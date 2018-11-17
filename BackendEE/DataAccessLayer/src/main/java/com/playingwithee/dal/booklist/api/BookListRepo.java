package com.playingwithee.dal.booklist.api;

import com.playingwithee.dal.booklist.api.dto.BookOverallData;

import java.io.Serializable;
import java.util.Set;

public interface BookListRepo extends Serializable {

    public Set<BookOverallData> getAllBooks();

}
