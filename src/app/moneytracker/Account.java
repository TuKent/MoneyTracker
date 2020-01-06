package app.moneytracker;

import app.moneytracker.model.user.User;

public class Account {

    private static class SingletonHelper {
        private static final Account INSTANCE = new Account();
    }

    public static Account getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private User user;

    public Account() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }
    public String getPassword(){
        return user.getPassword();
    }
}
