package app.moneytracker.model.category;

import java.util.ArrayList;
import java.util.List;

public class Categories implements CategoryObserver {

    private static class SingletonHelper {
        private static final Categories INSTANCE = new Categories();
    }

    public static Categories getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private List<Category> categories = new ArrayList<>();
    private CategoryModel model;

    private Categories() {
        model = new CategoryModelImpl();
        model.registerObserver(this);
        model.pull();
    }

    public CategoryModel getModel() {
        return model;
    }

    public Category getCategoryById(int id) {
        for (Category category: categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void onDataChanged(List<Category> categories) {
        this.categories.clear();
        this.categories.addAll(categories);
    }
}
