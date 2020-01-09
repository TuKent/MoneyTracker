package app.moneytracker.model.category;

import app.moneytracker.model.Database;
import app.util.Debug;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static final String TAG = CategoryDao.class.getSimpleName();

    public CategoryDaoImpl() {
    }

    @Override
    public void insert(Category category) {
        Database db = new Database();
        String SQL_INSERT_CATEGORY = "INSERT INTO Categories(Name,IsExpense) VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_CATEGORY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());
            ps.setBoolean(2, category.getIsExpense());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.setId(id);
                Debug.i(TAG, "Inserted Category id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(Category category, int id) {
        Database db = new Database();
        final String SQL_UPDATE_CATEGORY_BY_ID = "UPDATE Categories SET Name = ?, IsExpense = ? WHERE ID = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_CATEGORY_BY_ID);
            ps.setString(1, category.getName());
            ps.setBoolean(2, category.getIsExpense());
            ps.setInt(3, id);
            ps.executeUpdate();

            int result = ps.executeUpdate();
            Debug.i(TAG, "Updated Category id: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void delete(int id) {
        Database db = new Database();
        String SQL_DELELE_CATEGORY_BY_ID = "DELETE FROM Categories WHERE ID =?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELELE_CATEGORY_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();

            Debug.i(TAG, "Updated Category id: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<Category> getAllCategories() {
        Database db = new Database();
        List<Category> categories = new ArrayList<>();

        final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM Categories";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_CATEGORIES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                boolean isExpense = rs.getBoolean(3);

                Category category = new Category(id, name, isExpense);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return categories;
    }

}
