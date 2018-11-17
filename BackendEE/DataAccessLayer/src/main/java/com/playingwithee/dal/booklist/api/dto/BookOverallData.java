package com.playingwithee.dal.booklist.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookOverallData {

    private String title;

    private String authour;

    private BigDecimal basePrice;

    private BigDecimal discountRate;

}
