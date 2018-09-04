package com.animetop.web.core.common.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{

        }catch (Throwable e){
            System.out.println("initial session factory fail");
            throw new ExceptionInInitializerError(e);
        }
        return new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
