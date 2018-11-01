package com.playingwithee.dal.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PUBLISHING_DATE")
    private Date publishingDate;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_TO_AUTHOR",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authorList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_TO_DISCOUNT",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "discount_id")})
    private Set<Discount> discountList;

    @ManyToMany
    @JoinTable(name = "BOOK_TO_CATEGORY",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categoryList;


}
