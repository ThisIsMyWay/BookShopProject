package com.playingwithee.dal.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "DISCOUNT")
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long categoryId;

    @Column(name = "NAME_OF_PROMOTION")
    private String promotionName;

    @Column(name = "DISCOUNT_PERCENTAGE")
    private BigDecimal percentageDiscount;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "discountList")
    private Set<Book> bookList;

}
