package com.playingwithee.dal.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long authorId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "BIO")
    private String bio;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "authorList")
    private Set<Book> bookList;


}
