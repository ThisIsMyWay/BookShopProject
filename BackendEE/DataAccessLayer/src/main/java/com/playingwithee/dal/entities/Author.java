package com.playingwithee.dal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@NamedQuery(query = "SELECT DISTINCT a FROM Author a INNER JOIN FETCH a.bookList b where a.id = :id", name = "Author.getWithBooks")
@Getter
@Setter
public class Author extends BaseEntity {

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
