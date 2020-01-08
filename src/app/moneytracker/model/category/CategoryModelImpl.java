package app.moneytracker.model.category;

import java.util.ArrayList;
import java.util.List;

class CategoryModelImpl implements CategoryModel {

    private List<CategoryObserver> observers = new ArrayList<>();

    @Override
    public void pull() {
        notifyObservers();
    }

    @Override
    public void add(Category category) {

        CategoryDao dao = new CategoryDaoImpl();
        dao.insert(category);
        notifyObservers();
    }

    @Override
    public void update(Category category) {
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public void registerObserver(CategoryObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(CategoryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {

        CategoryDao dao = new CategoryDaoImpl();
        List<Category> categories = dao.getAllCategories();
        for (CategoryObserver observer: observers) {
            observer.onDataChanged(categories);
        }
    }
}
