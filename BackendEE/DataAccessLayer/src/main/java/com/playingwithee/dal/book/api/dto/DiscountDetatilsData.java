package com.playingwithee.dal.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiscountDetatilsData {

    private Long id;

    private String name;

    private Integer discountRate;
}
