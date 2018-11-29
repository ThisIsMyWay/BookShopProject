package com.playingwithee.service.books;

import com.playingwithee.dal.book.api.BookRepo;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.service.books.timediscount.TimeDiscount;
import com.playingwithee.service.books.timediscount.TimeDiscountBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class BooksService implements Serializable {

    @EJB
    private TimeDiscountBean timeDiscountBean;

    @EJB
    private BookRepo bookRepo;

    public Set<BookOverallData> getListOfBooks(){
        Set<BookOverallData> booksToReturn = bookRepo.getAllBooks();

        updateBooksWithTimeDiscount(booksToReturn);

        return booksToReturn;
    }

    private void updateBooksWithTimeDiscount(Set<BookOverallData> booksToReturn) {
        Set<TimeDiscount> actualPromotions = timeDiscountBean.getActualPromotions();

        Map<Long, TimeDiscount> accumulator =
                actualPromotions.stream()
                        .collect(Collectors.toMap(TimeDiscount::getIdOfBook, Function.identity()));

        booksToReturn.forEach(e ->
                Optional.ofNullable(accumulator.get(e.getIdOfBook()))
                        .ifPresent(p -> e.setDiscountRate(e.getDiscountRate() + p.getDiscountRate()))
        );
    }


}
