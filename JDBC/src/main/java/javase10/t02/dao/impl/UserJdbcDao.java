package javase10.t02.dao.impl;

import javase10.t02.dao.UserDao;
import javase10.t02.dao.executor.Executor;
import javase10.t02.entity.User;

import java.sql.Connection;


public class UserJdbcDao implements UserDao {

    private Executor executor;

    public UserJdbcDao(Connection connection) {
        this.executor = new Executor(connection);
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

    @Override
    public void update(User user) {
        String update = "update Users set name = " +
                "'" + user.getName() + "', age = '" + user.getAge() + "' where id = " + "'" + user.getId() + "'";
        executor.execUpdate(update);
    }

    @Override
    public void add(User user) {
        String add = String.format(
                "insert into Users (name, age) values ('%s', '%d')",
                user.getName(), user.getAge());
        executor.execUpdate(add);
    }

    @Override
    public void delete(long id) {

    }
}
