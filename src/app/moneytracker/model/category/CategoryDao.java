package app.moneytracker.model.category;

import java.util.List;

public interface CategoryDao {

    void insert(Category category);

    void update(Category category);

    void delete(int id);

    List<Category> getAllCategories();
}
