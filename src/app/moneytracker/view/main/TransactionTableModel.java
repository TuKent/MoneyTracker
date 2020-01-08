package app.moneytracker.view.main;

import app.moneytracker.model.category.Categories;
import app.moneytracker.model.category.Category;
import app.moneytracker.model.transaction.Transaction;
import app.moneytracker.model.transaction.TransactionObserver;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionTableModel extends AbstractTableModel implements TransactionObserver {

    private static final String[] COLUMN_NAMES = {"#", "Category", "Amount", "Date", "Description"};
    public static final int CATEGORY_TYPE = 0;
    public static final int CATEGORY = 1;
    public static final int AMOUNT = 2;
    public static final int DATE = 3;
    public static final int DESCRIPTION = 4;

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public int getRowCount() {
        return transactions.size();
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

        Transaction transaction = transactions.get(rowIndex);
        Category category = Categories.getInstance().getCategoryById(transaction.getCategoryId());
        if (columnIndex == CATEGORY_TYPE) {
            return category.getIsExpense() ? "-" : "+";
        } else if (columnIndex == CATEGORY) {
            return category.getName();
        } else if (columnIndex == AMOUNT) {
            return transaction.getAmount();
        } else if (columnIndex == DATE) {
            Date date = new Date(transaction.getTimeInMillis());
            return date;
        } else {
            return transaction.getDescription();
        }
    }

    @Override
    public void onDataChanged(List<Transaction> transactions) {
        this.transactions.clear();
        this.transactions.addAll(transactions);
        this.fireTableDataChanged();
    }

    public Transaction getTransaction(int rowIndex) {
        return transactions.get(rowIndex);
    }
}
