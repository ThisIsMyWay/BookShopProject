package com.playingwithee.service.books.timediscount;

import com.playingwithee.dal.book.api.BookRepo;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import org.jboss.logging.Logger;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Set;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TimeDiscountBean implements Serializable {

    private TimeDiscountService service = new TimeDiscountService();

    @Inject
    private Logger logger;

    @EJB
    private BookRepo bookRepo;

    @Lock(LockType.WRITE)
    @Schedule(hour = "*", minute = "*/5", persistent = false, info = "New promotion is drawn every single hour.")
    public void drawPromotion(){
        logger.info("new discounted books became drawn");
        Set<BookOverallData> allBooks = bookRepo.getAllBooks();
        service.drawPromotion(allBooks);
        //TODO save discount records into table
    }

    @Lock(LockType.READ)
    public Set<TimeDiscount> getActualPromotions(){
        return service.getActualPromotions();
    }
}
