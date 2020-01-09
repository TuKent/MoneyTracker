package app.moneytracker.controller.category;

import app.moneytracker.model.category.Category;
import app.moneytracker.model.category.CategoryModel;
import app.moneytracker.view.category.CategoryView;

import javax.swing.*;
import java.awt.*;

    public class CategoryControllerImpl implements CategoryController {
    Component parent;
    CategoryModel model;
    CategoryView view;

    public CategoryControllerImpl(Component parent, CategoryModel model, CategoryView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void updateCategory(int id) {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Edit Category",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_OPTION)
        {
            String name = view.getName();
            boolean isIncome = view.isExpense();
            Category category = new Category(0,name,isIncome);
            model.update(category,id);
        }
    }

        @Override
        public void deleteCategory(int id) {
            int option = JOptionPane.showConfirmDialog(parent,"Do you want to delete this Category ? ","Delete Category",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
            if (option == JOptionPane.YES_OPTION)
            {
                model.remove(id);
            }
        }
    }
