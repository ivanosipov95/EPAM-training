package javase10.t01;

import javase10.t01.executor.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Database {

    private static final String URL = "jdbc:mysql://144.76.237.23:3306/database";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "ivan";
    private static final String PASSWORD = "mypassword";
    private Executor executor;
    private Properties properties;


    public Database() {
        try {
            this.executor = new Executor(getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "UTF-8");
        return DriverManager.getConnection(URL, properties);
    }

    public User getById(long id) {
        String select = String.format("select * from users where id = '%d'", id);
        return executor.execQuery(select, resultSet -> {
            if (resultSet.absolute(1)) {
                return new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            } else {
                return null;
            }
        });
    }

    public void update(User user) {
        String update = "update Users set name = " +
                "'" + user.getName() + "', age = '" + user.getAge() + "' where id = " + "'" + user.getId() + "'";
        executor.execUpdate(update);
    }

    public void add(User user) {
        String add = String.format(
                "insert into Users (name, age) values ('%s', '%d')",
                user.getName(), user.getAge());
        executor.execUpdate(add);
    }

    public void drop(Connection connection, String table) {
        try (Statement st = connection.createStatement()) {
            st.execute(String.format("drop table if exists %s", table));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}