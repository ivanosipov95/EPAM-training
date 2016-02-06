package javase10.t02.dao;


import javase10.t02.entity.Entity;

public interface Dao<T extends Entity> {

    T getById(long id);

    void add(T value);

    void update(T value);

    void delete(long id);

}
