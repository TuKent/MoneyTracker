package app.moneytracker.view.category;

import app.moneytracker.model.category.Category;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Name", "Type"};
    private static final int NAME = 0;
    private static final int TYPE = 0;

    private List<Category> categories = new ArrayList<>();

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category = categories.get(rowIndex);
        if (columnIndex == NAME) {
            return category.getName();
        } else {
            return category.getType();
        }
    }
}
