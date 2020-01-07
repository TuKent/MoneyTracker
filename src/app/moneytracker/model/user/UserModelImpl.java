package app.moneytracker.model.user;

import app.moneytracker.model.category.CategoryObserver;

import java.util.ArrayList;
import java.util.List;

public class UserModelImpl implements UserModel {

    private List<CategoryObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(CategoryObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(CategoryObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void add(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public boolean checkUserandPassword(User users) {

        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUsernamandPassword(users);
        if (user != null)
        {
            return  true;
        }
        else {
            return  false;
        }
    }
}
