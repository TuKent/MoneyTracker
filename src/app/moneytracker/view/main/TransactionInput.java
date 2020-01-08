package app.moneytracker.view.main;

import app.moneytracker.model.category.Categories;
import app.moneytracker.model.category.Category;
import app.moneytracker.model.transaction.Transaction;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class TransactionInput {

    private JPanel rootPanel;

    private JTextField idField;
    private JComboBox categoryField;
    private JTextField amountField;
    private JDateChooser dateChooser;
    private JTextArea descriptionField;

    public static TransactionInput newTransaction() {
        return new TransactionInput();
    }

    public static TransactionInput editTransaction(Transaction transaction) {
        return new TransactionInput(transaction);
    }

    private TransactionInput() {

        initUIComponents();
    }

    private TransactionInput(Transaction transaction) {

        initUIComponents();

        Category category = Categories.getInstance().getCategoryById(transaction.getCategoryId());

        idField.setText(String.valueOf(transaction.getId()));
        categoryField.setSelectedItem(category.getName());
        amountField.setText(String.valueOf(transaction.getAmount()));
        dateChooser.setDate(new Date(transaction.getTimeInMillis()));
        descriptionField.setText(transaction.getDescription());
    }

    private void createUIComponents() {
        Date now = new Date(System.currentTimeMillis());
        dateChooser = new JDateChooser();
        dateChooser.setDate(now);
    }

    private void initUIComponents() {

        List<Category> categories = Categories.getInstance().getCategories();
        for (Category category : categories) {
            categoryField.addItem(category.getName());
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Category getCategory() {
        String name = (String) categoryField.getSelectedItem();
        return Categories.getInstance().getCategoryByName(name);
    }

    public float getAmount() {
        float amount = 0;
        try {
            amount = Float.parseFloat(amountField.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public long getTimeInMillis() {
        return dateChooser.getDate().getTime();
    }

    public String getDescription() {
        return descriptionField.getText();
    }
}
