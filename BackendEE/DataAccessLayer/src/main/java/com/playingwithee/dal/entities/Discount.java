package com.playingwithee.dal.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DISCOUNT")
@Getter
@Setter
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long discountId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RATE")
    private Integer rate;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "discountList")
    private Set<Book> bookList;

}
