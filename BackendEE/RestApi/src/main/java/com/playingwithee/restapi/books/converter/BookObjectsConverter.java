package com.playingwithee.restapi.books.converter;

import com.playingwithee.dal.booklist.api.dto.BookOverallData;
import com.playingwithee.restapi.books.presentationlayerobjects.BookListItem;

import java.util.Set;
import java.util.stream.Collectors;

public class BookObjectsConverter {

    public static Set<BookListItem> convert(Set<BookOverallData> items) {
        return items.stream().map(
                p -> new BookListItem(p.getIdOfBook(), p.getTitle(), p.getAuthour(), p.getBasePrice(), p.getDiscountRate())
        ).collect(Collectors.toSet());
    }
}
