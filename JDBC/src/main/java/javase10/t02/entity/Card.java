package javase10.t02.entity;

public class Card implements Entity {

    private long id;
    private long userId;
    private long accountId;
    private long type;

    public Card(long id, long userId, long accountId, long type) {
        this.id = id;
        this.userId = userId;
        this.accountId = accountId;
        this.type = type;
    }

    public Card(long userId, long accountId, long type) {
        this.userId = userId;
        this.accountId = accountId;
        this.type = type;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }
}
