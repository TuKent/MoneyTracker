package app.moneytracker.controller.category;

import app.moneytracker.model.category.Category;
import app.moneytracker.model.category.CategoryModel;
import app.moneytracker.view.category.CategoryView;

import javax.swing.*;
import java.awt.*;

public class NewCategoryControllerImpl implements NewCategoryController {

    private Component parent;
    private CategoryModel model;
    private CategoryView view;

    public NewCategoryControllerImpl(Component parent, CategoryModel model, CategoryView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void newCategory() {

        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "New Category",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String name = view.getName();
            boolean isIncome = view.isExpense();

            Category category = new Category(0, name, isIncome);
            model.add(category);
        }
    }
}
