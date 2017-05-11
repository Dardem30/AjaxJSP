package by.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Created by УВД on 10.05.2017.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSession();

    private static SessionFactory buildSession() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
