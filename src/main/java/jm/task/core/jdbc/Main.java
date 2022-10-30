package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Name_1", "LastName_1", (byte) 20);
        userDaoJDBC.saveUser("Name_2", "LastName_2", (byte) 25);
        userDaoJDBC.saveUser("Name_3", "LastName_3", (byte) 31);
        userDaoJDBC.saveUser("Name_4", "LastName_4", (byte) 38);
        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}
