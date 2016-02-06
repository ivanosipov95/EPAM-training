package javase10.t02.dao;

import javase10.t02.entity.Account;

public interface AccountDao extends Dao<Account> {

    Account getLast();

}
