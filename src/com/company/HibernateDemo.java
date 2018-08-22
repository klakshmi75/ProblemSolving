package com.company;

import com.company.enums.Gender;
import com.company.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class HibernateDemo {
    private static final SessionFactory SESSION_FACTORY;
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(com.company.model.Customer.class);
        // Extract the properties from the configuration file.
        Properties prop = config.getProperties();

        // Create StandardServiceRegistryBuilder using the properties.
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(prop);

        // Build a ServiceRegistry
        ServiceRegistry registry = builder.build();

        // Create the SessionFactory using the ServiceRegistry
        SESSION_FACTORY = config.buildSessionFactory(registry);
    }
    public static void main(String rags[]) {
        Customer customer = new Customer("Test_Customer", Gender.MALE, new Date(), "testemail" + new Random().nextInt() + "@gmail.com");
        addCustomer(customer);
    }
    public static void addCustomer(Customer customer) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            System.out.println("customer added successfully with id = " + customer.getId());
            transaction.commit();
        } catch(HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
