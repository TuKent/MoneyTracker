package app.moneytracker.model.category;

import java.util.List;

public interface CategoryObserver {

    void onDataChanged(List<Category> categories);
}
