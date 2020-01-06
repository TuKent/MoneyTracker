package app.moneytracker.model.category;

import app.moneytracker.model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE IF NOT EXISTS CategoriesTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    type text NOT NULL\n"
                + ");";
        try
        {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_CATEGORIES_TABLE);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void insert(Category category) {
        Database db = new Database();
        String SQL_INSERT_CATEGORY = "INSERT INTO CategoriesTable(name,type) + VALUE(?,?)";
        try
        {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_CATEGORY,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,category.getName());
            ps.setString(2,category.getType());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                int id = rs.getInt(1);
                category.setId(id);
                System.out.println("Inserted Category id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
}
