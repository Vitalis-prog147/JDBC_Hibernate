package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Name_1", "LastName_1", (byte) 20);
        userService.saveUser("Name_2", "LastName_2", (byte) 25);
        userService.saveUser("Name_3", "LastName_3", (byte) 31);
        userService.saveUser("Name_4", "LastName_4", (byte) 38);

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
