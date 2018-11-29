package com.playingwithee.dal.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class BookDetailsData {

    private Long idOfBook;

    private String title;

    private String ISBN;

    private String description;

    private Date dateOfPublishing;

    private BigDecimal basePrice;

    private Set<AuthorOfBook> authorsOfBook;

    private Set<DiscountDetatilsData> discounts;
}
