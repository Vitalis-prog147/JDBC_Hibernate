package jm.task.core.jdbc.dao;

import jakarta.persistence.criteria.CriteriaQuery;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getConnection();

    public UserDaoHibernateImpl() {

    }
    @SuppressWarnings("deprecation")
    @Override
    public void createUsersTable() {
        try {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

            session.createNativeQuery("""
                    CREATE TABLE IF NOT EXISTS users.users (
                    id int not null auto_increment, name VARCHAR(50),
                    lastname VARCHAR(50),
                    `age` INT NOT NULL,
                    PRIMARY KEY (id))
                    """).executeUpdate();
            transaction.commit();
            System.out.println("Table has been created");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
            System.out.println("Table has been created");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void removeUserById(long id) {
        Session session = Util.getConnection().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("User has been deleted");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        /**
         * PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
         ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()) {
         User user = new User();
         user.setId(resultSet.getLong("userId"));
         user.setName(resultSet.getString("name"));
         user.setLastName(resultSet.getString("last_name"));
         user.setAge(resultSet.getByte("age"));
         list.add(user);
         */

        Session session = Util.getConnection().openSession();
        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        Transaction transaction = session.beginTransaction();
        List<User> userList = session.createQuery(criteriaQuery).getResultList();
        try {
            transaction.commit();
            return userList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void cleanUsersTable() throws SQLException {

    }
/**
    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createNativeQuery("DELETE FROM users.users").executeUpdate();
            transaction.commit();
            System.out.println("Table was cleaned");
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
    */
}