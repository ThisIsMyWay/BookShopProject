package com.playingwithee.restapi.books.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookListItemVM extends HateoasSupportingVM {

    private Long idOfBook;

    private String title;

    private String author;

    private List<AuthorOfBookVM> authorsOfBook;

    private BigDecimal basePrice;

    private Integer discountRate;

}
