package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    /**
     * private static final String URL = "jdbc:mysql://localhost:3306/users";
     * private static final String USERNAME = "root";
     * private static final String PASSWORD = "root";
     * private static Connection;
     * <p>
     * <p>
     * public static Connection getConnection() {
     * try {
     * Class.forName("com.mysql.cj.jdbc.Driver");
     * connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
     * } catch (SQLException | ClassNotFoundException e) {
     * e.printStackTrace();
     * }
     * return connection;
     * }
     * <p>
     * public static SessionFactory getSessionFactory() {
     * Configuration configuration = new Configuration().addAnnotatedClass(User.class);
     * return configuration.buildSessionFactory();
     * }
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost:3306/users";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getConnection() {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", DRIVER)
                    .setProperty("hibernate.connection.url", HOST)
                    .setProperty("hibernate.connection.username", LOGIN)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sessionFactory;

    }
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}