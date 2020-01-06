package app.moneytracker.model.category;

public class CategoryModelImpl implements CategoryModel {
    @Override
    public void add(Category category) {

        CategoryDao dao = new CategoryDaoImpl();
        dao.insert(category);


    }
}
