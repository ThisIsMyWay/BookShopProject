package com.playingwithee.dal.booklist.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookOverallData {

    private String title;

    private String authour;

    private BigDecimal basePrice;

    private BigDecimal discountRate;

}
