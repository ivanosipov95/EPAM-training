package javase10.t02.dao.impl;

import javase10.t02.dao.CardDao;
import javase10.t02.dao.executor.Executor;
import javase10.t02.entity.Card;

import java.sql.Connection;


public class CardJdbcDao implements CardDao {

    private Executor executor;

    public CardJdbcDao(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public Card getById(long id)  {
        String select = String.format("select * from Cards where user_id = '%d'", id);
        return executor.execQuery(select, resultSet -> {
            if (resultSet.absolute(1)) {
                return new Card(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("account_id"),
                        resultSet.getLong("type")
                );
            } else {
                return null;
            }
        });
    }

    @Override
    public void add(Card value) {
        String add = String.format(
                "insert into Cards (user_id, account_id, type) values ('%d', '%d', '%s')",
                value.getUserId(), value.getAccountId(), value.getType());
        executor.execUpdate(add);
    }

    @Override
    public void update(Card value) {

    }

    @Override
    public void delete(long id)  {
        String delete = String.format("delete from Cards where Cards.id = '%d'", id);
        executor.execUpdate(delete);
    }
}
