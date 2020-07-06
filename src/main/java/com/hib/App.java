package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.reflection.XMethod;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.jnlp.UnavailableServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args)throws IOException {
        User user = new User();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("******Enter User Details******");

        System.out.println("Enter User Id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        user.setUserId(id);

        System.out.println("Enter User name: ");
        String name = bufferedReader.readLine();
        user.setUsername(name);

        System.out.println("User Created By: ");
        String userCreatedBy = bufferedReader.readLine();
        user.setCreatedBy(userCreatedBy);

//        There are two ways of mapping persistent class.
//                1. using addAnnotatedClass method
//                2. mapping it in hibernate.cfg.xml file

//        Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
//        SessionFactory sf = con.buildSessionFactory();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

}
