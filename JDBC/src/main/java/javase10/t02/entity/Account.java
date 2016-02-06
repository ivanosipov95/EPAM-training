package javase10.t02.entity;


public class Account implements Entity {

    private long id;
    private double amount;
    private long status;

    public Account() {
        amount = 0;
        status = 1;
    }

    public Account(long id, double amount, long  status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
