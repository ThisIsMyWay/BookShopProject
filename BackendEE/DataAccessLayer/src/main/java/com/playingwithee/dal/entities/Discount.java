package com.playingwithee.dal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "DISCOUNT")
@Getter
@Setter
public class Discount extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "RATE")
    private Integer rate;

    @Column(name = "START_DATE")
    private Timestamp startingDate;

    @Column(name = "END_DATE")
    private Timestamp endingDate;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "discountList")
    private Set<Book> bookList;

    public Discount() {
    }

    public Discount(Long id, String name, Integer rate, Timestamp startingDate, Timestamp endingDate, Set<Book> bookList) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.bookList = bookList;
    }
}
