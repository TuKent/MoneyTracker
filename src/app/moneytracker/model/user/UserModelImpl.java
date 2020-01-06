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
