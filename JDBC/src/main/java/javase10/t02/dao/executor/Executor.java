package javase10.t02.dao.executor;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

    private final Connection connection;
    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(update);
        } catch (SQLException e) {
            throw new RuntimeException("Can't execute query", e);
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler)  {
        T value = null;

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);

            try (ResultSet result = statement.getResultSet()) {
                value = handler.handle(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't execute query", e);
        }

        return value;
    }
}
