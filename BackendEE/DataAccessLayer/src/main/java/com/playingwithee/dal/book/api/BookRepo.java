package com.playingwithee.dal.book.api;

import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface BookRepo extends Serializable {

    public Set<BookOverallData> getAllBooks();
    
    public Optional<BookDetailsData> getBookDetailsById(Long id);

}
