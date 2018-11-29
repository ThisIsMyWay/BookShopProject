package com.playingwithee.restapi.books.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiscountVM {

    private String name;

    private Integer discountRate;
}
