package app.moneytracker.model.user;

import app.moneytracker.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public void insert(User user) {

        Database db = new Database();
        final String SQL_CREATE_USER = "INSERT INTO Users(Username, Password) VALUES(?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public User checkAccount(String username, String password) {

        Database db = new Database();
        try {
            final String SQL_GET_USERNAME_AND_PASSWORD = "SELECT * FROM Users WHERE Username=? and Password=?";

            PreparedStatement ps = db.getConnection().prepareStatement(SQL_GET_USERNAME_AND_PASSWORD);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String strUsername = rs.getString(2);
                String strPassword = rs.getString(3);
                User user = new User(0, strUsername,strPassword);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return null;
    }
}
