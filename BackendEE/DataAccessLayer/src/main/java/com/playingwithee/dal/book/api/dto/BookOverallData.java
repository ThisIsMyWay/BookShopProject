package com.playingwithee.dal.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookOverallData {

    private Long idOfBook;

    private String title;

    private String authour;

    private BigDecimal basePrice;

    private Integer discountRate;

}
