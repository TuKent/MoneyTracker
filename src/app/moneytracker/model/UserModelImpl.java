package app.moneytracker.model;

public class UserModelImpl implements UserModel {

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
}
