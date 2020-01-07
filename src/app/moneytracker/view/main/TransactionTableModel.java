package app.moneytracker.view.main;

import app.moneytracker.model.transaction.Transaction;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TransactionTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Category", "Amount", "Date", "Description"};
    private static final int CATEGORY = 0;
    private static final int AMOUNT = 1;
    private static final int DATE = 2;
    private static final int DESCRIPTION = 3;

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
        if (columnIndex == CATEGORY) {
            return transaction.getCategoryId();
        } else if (columnIndex == AMOUNT) {
            return transaction.getAmount();
        } else if (columnIndex == DATE) {
            return transaction.getDate();
        } else{
            return transaction.getDescription();
        }
    }
}
