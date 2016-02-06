package javase10.t02.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class is used to connect to the database.
 * Maximum number of connections 10.
 */

public class Pool {

    private static final int GET_CONNECTION_MILLIS = 1000;
    private static final String URL = "jdbc:mysql://144.76.237.23:3306/database";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "ivan";
    private static final String PASSWORD = "mypassword";
    private static int CAPACITY = 5;
    private static Pool INSTANCE;
    private Map<Connection, Boolean> connections;
    private Properties properties;

    private Pool() {
        try {
            Class.forName(DRIVER);
            properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useUnicode","true");
            properties.setProperty("characterEncoding","UTF-8");
            connections = new IdentityHashMap<>(CAPACITY);
            for (int i = 0; i < CAPACITY; i++) {
                connections.put(createConnection(), true);
            }
        } catch ( ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Pool getInstance() {
        if (INSTANCE == null)
            synchronized (Pool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Pool();
                }
            }

        return INSTANCE;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, properties);
    }

    public Connection getConnection() {
        for (Map.Entry<Connection, Boolean> entry : connections.entrySet())
            if (entry.getValue())
                synchronized (this) {
                    if (entry.getValue()) {
                        Connection key = entry.getKey();
                        connections.put(key, false);
                        return key;
                    }
                }
        try {
            Thread.sleep(GET_CONNECTION_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return getConnection();
    }

    public void free(Connection connection) {
        connections.put(connection, true);
    }
}
