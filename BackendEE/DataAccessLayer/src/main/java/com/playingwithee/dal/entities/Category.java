package com.playingwithee.dal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long categoryId;

    @Column(name = "NAME", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "categoryList")
    private Set<Book> bookList;
}
