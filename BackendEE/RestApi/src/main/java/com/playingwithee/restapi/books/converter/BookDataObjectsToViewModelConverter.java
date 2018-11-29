package com.playingwithee.restapi.books.converter;

import com.playingwithee.dal.book.api.dto.AuthorOfBook;
import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.books.viewmodels.AuthorOfBookVM;
import com.playingwithee.restapi.books.viewmodels.BookDetailsVM;
import com.playingwithee.restapi.books.viewmodels.BookListItemVM;
import com.playingwithee.restapi.books.viewmodels.DiscountVM;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDataObjectsToViewModelConverter {

    public static Set<BookListItemVM> convert(Set<BookOverallData> items) {
        return items.stream().map(
                p -> new BookListItemVM(p.getIdOfBook(), p.getTitle(), p.getAuthour(), p.getBasePrice(), p.getDiscountRate())
        ).collect(Collectors.toSet());
    }

    public static Optional<BookDetailsVM> convert(Optional<BookDetailsData> bookDetails) {
       return bookDetails.map(b -> new BookDetailsVM(b.getIdOfBook(),
                b.getTitle(),
                b.getAuthorsOfBook().stream().map(AuthorOfBook::getName).collect(Collectors.joining(", ")),
                b.getISBN(),
                b.getDescription(),
                b.getDateOfPublishing(),
                b.getBasePrice(),
                b.getAuthorsOfBook().stream().map(a -> new AuthorOfBookVM(a.getAuthorId(), a.getName())).collect(Collectors.toSet()),
                b.getDiscounts().stream().map( d -> new DiscountVM(d.getName(), d.getDiscountRate())).collect(Collectors.toSet())));

    }
}
