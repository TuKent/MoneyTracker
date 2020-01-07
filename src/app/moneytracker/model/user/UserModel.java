package app.moneytracker.model.user;

import app.moneytracker.model.category.CategoryObserver;

public interface UserModel {

    void registerObserver(CategoryObserver observer);

    void unregisterObserver(CategoryObserver observer);

    void add(User user);

    void update(User user);

    void remove(int id);

    boolean checkUserandPassword(User user);
}
