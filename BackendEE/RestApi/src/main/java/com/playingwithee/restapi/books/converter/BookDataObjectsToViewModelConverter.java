package com.playingwithee.restapi.books.converter;

import com.playingwithee.dal.book.api.dto.AuthorOfBook;
import com.playingwithee.dal.book.api.dto.BookDetailsData;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.restapi.books.viewmodels.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDataObjectsToViewModelConverter {

    private BookDataObjectsToViewModelConverter(){}

    public static BookListVM convert(Set<BookOverallData> items) {
        final BookListVM bookListVM = new BookListVM();
        final List<BookListItemVM> bookList = items.stream().map(
                p -> new BookListItemVM(p.getIdOfBook(),
                        p.getTitle(),
                        p.getAuthors(),
                        p.getAuthorsOfBook().stream()
                                .map(a -> new AuthorOfBookVM(a.getAuthorId(), a.getName()))
                                .sorted(Comparator.comparing(AuthorOfBookVM::getAuthorId))
                                .collect(Collectors.toList()),
                        p.getBasePrice(),
                        p.getDiscountRate())
        ).sorted(Comparator.comparing(BookListItemVM::getIdOfBook))
                .collect(Collectors.toList());
        bookListVM.getBookList().addAll(bookList);

        return bookListVM;
    }

    public static Optional<BookDetailsVM> convert(Optional<BookDetailsData> bookDetails) {
       return bookDetails.map(b -> new BookDetailsVM(b.getIdOfBook(),
                b.getTitle(),
                b.getAuthorsOfBook().stream().map(AuthorOfBook::getName).collect(Collectors.joining(", ")),
                b.getISBN(),
                b.getDescription(),
                b.getDateOfPublishing(),
                b.getBasePrice(),
                b.getAuthorsOfBook().stream()
                        .map(a -> new AuthorOfBookVM(a.getAuthorId(), a.getName()))
                        .sorted(Comparator.comparing(AuthorOfBookVM::getAuthorId))
                        .collect(Collectors.toList()),
                b.getDiscounts().stream().map( d -> new DiscountVM(d.getName(), d.getDiscountRate())).collect(Collectors.toSet())));

    }
}
