package com.playingwithee.service;

import com.playingwithee.dal.book.api.BookRepo;
import com.playingwithee.dal.book.api.dto.BookOverallData;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Set;

@Singleton
@Startup
public class SampleSingleton {

    @EJB
    private BookRepo repo;

    @Inject
    private Logger logger;



    public SampleSingleton() {
    }


    @PostConstruct
    public void postConstruct(){
        logger.info("sngleton postconstruct");

        Set<BookOverallData> allBooks = repo.getAllWithDiscountsAndAuthors();
        logger.info("sngleton s");


    }
}
