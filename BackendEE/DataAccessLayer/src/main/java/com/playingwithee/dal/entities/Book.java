package com.playingwithee.dal.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@NamedQueries({
        @NamedQuery(name= "Book.getAllWithDiscountsAndAuthors", query = "SELECT DISTINCT b FROM Book as b LEFT JOIN FETCH b.discountList LEFT JOIN FETCH b.authorList"),
        @NamedQuery(name= "Book.getOneBookWithDiscountsAndAuthors", query = "SELECT DISTINCT b FROM Book as b LEFT JOIN FETCH b.discountList LEFT JOIN FETCH b.authorList where b.id = :id"),})

@Getter
@Setter
public class Book extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "DESCRIPTION")
    @Type(type="text")
    private String description;

    @Column(name = "PUBLISHING_DATE")
    private Date publishingDate;

    @Column(name = "BASE_PRICE")
    private BigDecimal basePrice;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_TO_AUTHOR",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authorList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "BOOK_TO_DISCOUNT",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "discount_id")})
    private Set<Discount> discountList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_TO_CATEGORY",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categoryList;


}
