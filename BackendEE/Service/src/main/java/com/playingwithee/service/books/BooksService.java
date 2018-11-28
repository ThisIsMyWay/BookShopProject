package com.playingwithee.service.books;

import com.playingwithee.dal.booklist.api.BookListRepo;
import com.playingwithee.dal.booklist.api.dto.BookOverallData;
import com.playingwithee.service.books.timediscount.TimeDiscount;
import com.playingwithee.service.books.timediscount.TimeDiscountBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Stateless
public class BooksService implements Serializable {

    @EJB
    private TimeDiscountBean timeDiscountBean;

    @EJB
    private BookListRepo bookListRepo;

    public Set<BookOverallData> getListOfBooks(){
        Set<BookOverallData> booksToReturn = bookListRepo.getAllBooks();

        updateBooksWithTimeDiscount(booksToReturn);

        return booksToReturn;
    }

    private void updateBooksWithTimeDiscount(Set<BookOverallData> booksToReturn) {
        Set<TimeDiscount> actualPromotions = timeDiscountBean.getActualPromotions();

        booksToReturn.forEach(
            p -> {
                final Optional<TimeDiscount> promotion = actualPromotions.stream().filter(ap -> Objects.equals(ap.getIdOfBook(), p.getIdOfBook())).findFirst();
                promotion.ifPresent(ap -> p.setDiscountRate(ap.getDiscountRate() + p.getDiscountRate()));
            }
        );
    }


}
