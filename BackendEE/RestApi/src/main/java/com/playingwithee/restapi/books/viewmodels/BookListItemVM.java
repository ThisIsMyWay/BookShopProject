package com.playingwithee.restapi.books.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookListItemVM extends HateoasSupportingVM {

    private Long idOfBook;

    private String title;

    private String author;

    private BigDecimal basePrice;

    private Integer discountRate;

    public BookListItemVM(Long idOfBook, String title, String author, BigDecimal basePrice, Integer discountRate) {
        this.idOfBook = idOfBook;
        this.title = title;
        this.author = author;
        this.basePrice = basePrice;
        this.discountRate = discountRate;
    }
}
