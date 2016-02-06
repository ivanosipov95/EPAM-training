package javase10.t02.entity;


import java.io.Serializable;

public interface Entity extends Serializable {

    public long getId();

    public void setId(long id);
}
