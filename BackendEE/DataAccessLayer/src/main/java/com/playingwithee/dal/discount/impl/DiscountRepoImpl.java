package com.playingwithee.dal.discount.impl;

import com.playingwithee.dal.discount.api.DiscountRepo;
import com.playingwithee.dal.discount.api.dto.DiscountData;
import com.playingwithee.dal.entities.Book;
import com.playingwithee.dal.entities.Discount;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class DiscountRepoImpl implements DiscountRepo {

    @PersistenceContext(unitName = "bookShopDB")
    private transient EntityManager entityManager;

    @Override
    public void addDiscount(DiscountData discountData) {

        Set<Book> listOfLinkedBooks = discountData.getIdsOfBooksCoveredByThisDiscount().stream()
                .map(idOfBook -> entityManager.find(Book.class, idOfBook)).collect(Collectors.toSet());

        Discount discount = new Discount(discountData.getDiscountId(),
                discountData.getName(),
                discountData.getRate(),
                discountData.getStartingDate(),
                discountData.getEndingDate(),
                listOfLinkedBooks);

        listOfLinkedBooks.forEach(a -> {
            Optional.ofNullable(a.getDiscountList()).orElseGet(Collections::emptySet)
                    .add(discount);
        });
    }
}
