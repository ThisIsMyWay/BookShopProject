package com.playingwithee.dal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "DISCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long discountId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RATE")
    private Integer rate;

    @Column(name = "START_DATE")
    private Timestamp startingDate;

    @Column(name = "END_DATE")
    private Timestamp endingDate;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "discountList", cascade = CascadeType.PERSIST)
    private Set<Book> bookList;

}
