package com.playingwithee.dal.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long authorId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "BIRTH_DATE_ACCURACY_INDICATOR", columnDefinition = "integer default 0")
    @Enumerated(EnumType.ORDINAL)
    private DateAccuracy birthDateAccuracyIndicator;

    @Column(name = "DEATH_DATE")
    private Date deathDate;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "authorList")
    private Set<Book> bookList;

}
