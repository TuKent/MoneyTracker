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
    public User getUser(String username) {

        Database db = new Database();
        User user = null;
        try {
            final String SQL_GET_USER_ACCOUNT = "SELECT * FROM Users WHERE Username=?";

            PreparedStatement ps = db.getConnection().prepareStatement(SQL_GET_USER_ACCOUNT);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String strUsername = rs.getString(2);
                String strPassword = rs.getString(3);
                user = new User(id, strUsername,strPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return user;
    }
}
