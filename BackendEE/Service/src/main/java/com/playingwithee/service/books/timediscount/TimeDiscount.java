package com.playingwithee.service.books.timediscount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TimeDiscount {
    private Long idOfBook;
    private Integer discountRate;

}
