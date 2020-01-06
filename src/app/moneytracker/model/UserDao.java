package app.moneytracker.model;

public interface UserDao {

    void insert(User user);

    void update(User user);

    void delete(int id);
}
