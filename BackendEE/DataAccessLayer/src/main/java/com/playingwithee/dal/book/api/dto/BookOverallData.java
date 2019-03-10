package com.playingwithee.dal.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
public class BookOverallData {

    private Long idOfBook;

    private String title;

    private String authors;

    private Set<AuthorOfBook> authorsOfBook;

    private BigDecimal basePrice;

    private Integer discountRate;

}
