package com.playingwithee.dal.discount.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@AllArgsConstructor
public class DiscountData {

    private Long discountId;

    private String name;

    private Integer rate;

    private Timestamp startingDate;

    private Timestamp endingDate;

    private Set<Long> idsOfBooksCoveredByThisDiscount;
}
