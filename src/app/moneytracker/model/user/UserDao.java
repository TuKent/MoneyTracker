package app.moneytracker.model.user;

public interface UserDao {

    void insert(User user);

    void update(User user);

    void delete(int id);

    User checkAccount(String username, String password);
}
