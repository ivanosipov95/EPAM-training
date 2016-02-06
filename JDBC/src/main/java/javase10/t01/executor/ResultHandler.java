package javase10.t01.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandler<T> {
	T handle(ResultSet resultSet) throws SQLException;
}
