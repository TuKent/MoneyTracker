package app.moneytracker.model.category;

import java.util.List;

public interface CategoryModel {

    void pull();

    void add(Category category);

    void update(Category category);

    void remove(int id);

    List<Category> getAllCategories();

    void registerObserver(CategoryObserver observer);

    void unregisterObserver(CategoryObserver observer);
}
