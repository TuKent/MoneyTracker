package app.moneytracker.model.user;

import app.moneytracker.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS UsersTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    username text NOT NULL,\n"
                + "    password text NOT NULL\n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_USERS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
    @Override
    public void insert(User user) {
        Database db = new Database();
        final String SQL_CREATE_USER = "INSERT INTO UsersTable(username, password)" +
                "VALUES(?,?)";
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
    public User getUsernamandPassword(User users) {
        Database db = new Database();
        final String SQL_GET_USERNAME_AND_PASSWORD = "SELECT * FROM UsersTable WHERE username = ? and password = ?";
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            ps = db.getConnection().prepareStatement(SQL_GET_USERNAME_AND_PASSWORD);
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getPassword());
            rs = ps.executeQuery();
            if (rs.next())
            {
                User user = new User();
                String fullName = rs.getString(2);
                String password = rs.getString(3);
                user.setUsername(fullName);
                user.setPassword(password);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();

        return null;
    }
}
