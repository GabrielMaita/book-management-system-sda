package com.sda.gabrielm.bookmanagement.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {
    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager(){
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("ex1_hibernate");
    }

    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }

    protected void setAnnotatedClasses(Configuration configuration){
      // Hibernate model will be added here

    }
}