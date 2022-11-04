package jm.task.core.jdbc;


//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;


public class Main {
    /**
    private static final UserService userService = new UserServiceImpl();
    public static final User user1 = new User("Name_1", "LastName_1", (byte) 20);
    public static final User user2 = new User("Name_2", "LastName_2", (byte) 25);
    public static final User user3 = new User("Name_3", "LastName_3", (byte) 31);
    public static final User user4 = new User("Name_4", "LastName_4", (byte) 38);
     */
    public static void main(String[] args) throws SQLException {
        /**
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Name_1", "LastName_1", (byte) 20);
        userDaoJDBC.saveUser("Name_2", "LastName_2", (byte) 25);
        userDaoJDBC.saveUser("Name_3", "LastName_3", (byte) 31);
        userDaoJDBC.saveUser("Name_4", "LastName_4", (byte) 38);
        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
         */

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
