package app.moneytracker.model.user;

public interface UserModel {

    void add(User user);

    void update(User user);

    void remove(int id);

    boolean checkAccount(User user);
}
