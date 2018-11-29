package com.playingwithee.restapi.books.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Getter
@AllArgsConstructor
public class BookDetailsVM {

    private Long idOfBook;

    private String title;

    private String authors;

    private String ISBN;

    private String description;

    private Date dateOfPublishing;

    private BigDecimal basePrice;

    private Set<AuthorOfBookVM> authorsOfBook;

    private Set<DiscountVM> discounts;

}
