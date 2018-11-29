package com.playingwithee.restapi.books.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BookListItemVM  {

    private Long idOfBook;

    private String title;

    private String authour;

    private BigDecimal basePrice;

    private Integer discountRate;

}
