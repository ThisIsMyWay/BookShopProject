package com.playingwithee.restapi.books.presentationlayerobjects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookListItem {

    private Long idOfBook;

    private String title;

    private String authour;

    private BigDecimal basePrice;

    private Integer discountRate;
}
