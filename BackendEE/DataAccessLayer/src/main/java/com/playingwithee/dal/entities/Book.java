package com.playingwithee.dal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    Long id;

    String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
