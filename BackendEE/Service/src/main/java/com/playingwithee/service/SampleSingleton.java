package com.playingwithee.service;

import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SampleSingleton {

    public SampleSingleton() {
        System.out.println("sngleton running");
    }
}
