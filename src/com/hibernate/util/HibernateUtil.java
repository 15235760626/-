package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author :Mr.Xu
 * Date    :2019-4-8
 */
public class HibernateUtil {

    private static SessionFactory SESSIONFACTORY = null;
    private static Session SESSION = null;
    static {

//      StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//      SESSIONFACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Configuration configure = new Configuration().configure();
        SESSIONFACTORY = configure.buildSessionFactory();


    }


    public static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;
    }

    public static Session getSession(){
        SESSION = getSessionFactory().openSession();
        return SESSION;
    }

}
