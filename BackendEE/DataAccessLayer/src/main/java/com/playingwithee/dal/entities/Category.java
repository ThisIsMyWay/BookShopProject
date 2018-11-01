package com.playingwithee.dal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "categoryList")
    private Set<Book> bookList;
}
