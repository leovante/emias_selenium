package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

//public class HibernateUtil {
//    private static SessionFactory sessionFactory ;
//    static {
//        Configuration configuration = new Configuration();
//
//        configuration.addAnnotatedClass(Employee.class);
//        configuration.addAnnotatedClass(Address.class);
//        configuration.setProperty("connection.driver_class","com.mysql.jdbc.Driver");
//        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
//        configuration.setProperty("hibernate.connection.username", "root");
//        configuration.setProperty("hibernate.connection.password", "root");
//        configuration.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.setProperty("hibernate.show_sql", "true");
//        configuration.setProperty(" hibernate.connection.pool_size", "10");
//
//
//        // configuration
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        sessionFactory = configuration.buildSessionFactory(builder.build());
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}