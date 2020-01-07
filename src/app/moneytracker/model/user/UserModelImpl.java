package app.moneytracker.model.user;

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

    @Override
    public User getUser(String username) {

        UserDao dao = new UserDaoImpl();
        User user = dao.getUser(username);
        return user;
    }
}
