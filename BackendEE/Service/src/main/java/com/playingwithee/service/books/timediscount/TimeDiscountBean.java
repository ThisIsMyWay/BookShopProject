package com.playingwithee.service.books.timediscount;

import com.playingwithee.dal.book.api.BookRepo;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import com.playingwithee.dal.discount.api.DiscountRepo;
import com.playingwithee.dal.discount.api.dto.DiscountData;
import org.jboss.logging.Logger;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TimeDiscountBean implements Serializable {

    private TimeDiscountService service = new TimeDiscountService();

    @Inject
    private Logger logger;

    @EJB
    private BookRepo bookRepo;

    @EJB
    private DiscountRepo discountRepo;

    @Lock(LockType.WRITE)
    @Schedule(hour = "*", minute = "*/2", persistent = false, info = "New promotion is drawn every single hour.")
    public void drawPromotion(){
        logger.info("new discounted books became drawn");
        saveDiscounts();
        Set<BookOverallData> allBooks = bookRepo.getAllWithDiscountsAndAuthors();
        service.drawPromotion(allBooks);
    }

    private void saveDiscounts() {
        final Set<TimeDiscount> actualPromotions = service.getActualPromotions();
        final Optional<TimeDiscount> firstElement = actualPromotions.stream().findFirst();
        if (!firstElement.isPresent()) {
            return;
        }

        TimeDiscount timeDiscount = firstElement.get();
        DiscountData discountData = new DiscountData(null,
                "HAPPY_HOUR",
                timeDiscount.getDiscountRate(),
                timeDiscount.getTimeOfDraw(),
                new Timestamp(System.currentTimeMillis()),
                        actualPromotions.stream().map(TimeDiscount::getIdOfBook).collect(Collectors.toSet()));
        discountRepo.addDiscount(discountData);

    }

    @Lock(LockType.READ)
    public Set<TimeDiscount> getActualPromotions(){
        return service.getActualPromotions();
    }
}
