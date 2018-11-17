package com.playingwithee.service;

import com.playingwithee.dal.booklist.api.BookListRepo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SampleSingleton {

    @EJB
    BookListRepo repo;

    public SampleSingleton() {
        System.out.println("sngleton running");
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("sngleton postconstruct");

        repo.getAllBooks();

    }
}
