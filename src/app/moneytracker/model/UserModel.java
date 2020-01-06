package app.moneytracker.model;

public interface UserModel {

    void add(User user);

    void update(User user);

    void remove(int id);

    boolean checkUserandPassword(User user);
}
