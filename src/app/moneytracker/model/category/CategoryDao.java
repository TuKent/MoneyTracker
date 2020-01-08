package app.moneytracker.model.category;

import java.util.List;

public interface CategoryDao {

    void insert(Category category);


//    Category getCategoryById(int id);

    void update(Category category,int id );

    void delete(int id);

    List<Category> getAllCategories();
}
