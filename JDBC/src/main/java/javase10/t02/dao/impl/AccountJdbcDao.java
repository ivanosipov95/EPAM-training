package javase10.t02.dao.impl;

import javase10.t02.dao.AccountDao;
import javase10.t02.dao.executor.Executor;
import javase10.t02.entity.Account;

import java.sql.Connection;

public class AccountJdbcDao implements AccountDao {

    private Executor executor;

    public AccountJdbcDao(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public Account getLast()  {
        String select = "SELECT * FROM Accounts ORDER BY id DESC LIMIT 1";
        return executor.execQuery(select, resultSet -> {
            if (resultSet.absolute(1)) {
                return new Account(resultSet.getLong("id"),
                        resultSet.getDouble("amount"),
                        resultSet.getLong("status"));
            } else {
                return null;
            }
        });
    }

    @Override
    public Account getById(long id)  {
        String select = String.format("select * from Accounts where id = '%d'", id);
        return executor.execQuery(select, resultSet -> {
            if (resultSet.absolute(1)) {
                return new Account(resultSet.getLong("id"),
                        resultSet.getDouble("amount"),
                        resultSet.getLong("status"));
            } else {
                return null;
            }
        });
    }

    @Override
    public void add(Account value)  {
        String add = "insert into Accounts (amount, status) values" +
                " ('"+ value.getAmount() + "', '"+ value.getStatus() + "')";
        executor.execUpdate(add);
    }

    @Override
    public void update(Account value)  {
        String update = "update Accounts set amount = " +
                "'"+ value.getAmount() + "', status = '"+ value.getStatus() + "' where id = " + "'" + value.getId() + "'";
        executor.execUpdate(update);
    }

    @Override
    public void delete(long id)  {
        String delete = String.format("delete from Accounts where Accounts.id = '%d'", id);
        executor.execUpdate(delete);
    }
}
