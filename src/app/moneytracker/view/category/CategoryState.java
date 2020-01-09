package app.moneytracker.view.category;

import app.moneytracker.controller.category.CategoryController;
import app.moneytracker.controller.category.CategoryControllerImpl;
import app.moneytracker.model.category.Categories;
import app.moneytracker.controller.category.NewCategoryController;
import app.moneytracker.controller.category.NewCategoryControllerImpl;
import app.moneytracker.model.category.Category;
import app.moneytracker.model.category.CategoryModel;
import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryState extends Pane {

    private static final String TAG = CategoryState.class.getSimpleName();

    private JPanel rootPanel;

    private JTable categoryTable;
    private CategoryTableModel categoryTableModel;

    private JButton deleteButton;
    private JButton editButton;
    private JButton newButton;
    private JButton backToHomeButton;

    private CategoryModel model;

    public CategoryState() {

        setComponent(rootPanel);

        initUiComponents();

        model = Categories.getInstance().getModel();
        model.registerObserver(categoryTableModel);
    }

    private void initUiComponents() {

        categoryTableModel = new CategoryTableModel();
        categoryTable.setModel(categoryTableModel);

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClicked(e);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClicked(e);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClicked(e);
            }
        });

        backToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.MAIN);
            }
        });
    }

    private void onNewClicked(ActionEvent e) {
        NewCategoryController controller = new NewCategoryControllerImpl(rootPanel, model, new CategoryInput());
        controller.newCategory();
    }

    private void onEditClicked(ActionEvent e) {
        CategoryController controller = new CategoryControllerImpl(rootPanel, model, new CategoryInput());
        CategoryTableModel tableModel = (CategoryTableModel) categoryTable.getModel();

        int row = categoryTable.getSelectedRow();
        if (row >= 0) {
            Category category = tableModel.getValueAt(row);
            controller.updateCategory(category.getId());
        }
    }

    private void onDeleteClicked(ActionEvent e) {
        CategoryController controller = new CategoryControllerImpl(rootPanel,model,new CategoryInput());
        CategoryTableModel tableModel = (CategoryTableModel) categoryTable.getModel();

        int row = categoryTable.getSelectedRow();
        if (row >= 0)
        {
            Category category = tableModel.getValueAt(row);
            controller.deleteCategory(category.getId());
        }
    }

    @Override
    public void onPaneOpened() {
        model.pull();
    }

    @Override
    public void onPaneClosed() {
    }
}
