package com.playingwithee.restapi.books.viewmodels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Getter
@AllArgsConstructor
public class BookDetailsVM extends HateoasSupportingVM {

    private Long idOfBook;

    private String title;

    private String authors;

    private String ISBN;

    private String description;

    @JsonSerialize(as = Date.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfPublishing;

    private BigDecimal basePrice;

    private Set<AuthorOfBookVM> authorsOfBook;

    private Set<DiscountVM> discounts;

}
