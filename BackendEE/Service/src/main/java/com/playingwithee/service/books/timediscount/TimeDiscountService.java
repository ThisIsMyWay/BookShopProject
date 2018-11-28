package com.playingwithee.service.books.timediscount;

import com.playingwithee.dal.booklist.api.dto.BookOverallData;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class TimeDiscountService {

    private Set<TimeDiscount> listOfActualPromotions = new HashSet<>();
    private static final int AMOUNT_OF_DISCOUNTED_BOOKS = 3;

    public void drawPromotion(Set<BookOverallData> listOfBooks) {
        int discountLevel = drawDiscountLevel();

        listOfActualPromotions = listOfBooks.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), collectedList -> {
                        Collections.shuffle(collectedList);
                        return collectedList.stream();
                        }))
                .limit(AMOUNT_OF_DISCOUNTED_BOOKS)
                .map(item -> new TimeDiscount(item.getIdOfBook(), discountLevel))
                .collect(Collectors.toSet());
    }

    private int drawDiscountLevel() {
        return (int) (Math.random() * 90 +1);
    }


    public Set<TimeDiscount> getActualPromotions() {
        return listOfActualPromotions;
    }

}
