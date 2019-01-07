package com.playingwithee.service.books.timediscount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class TimeDiscount {
    private Long idOfBook;
    private Integer discountRate;
    private Timestamp timeOfDraw;

}
