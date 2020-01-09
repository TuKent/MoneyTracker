package app.moneytracker.controller.transaction;

import app.moneytracker.Account;
import app.moneytracker.model.category.Category;
import app.moneytracker.model.transaction.Transaction;
import app.moneytracker.model.transaction.TransactionModel;
import app.moneytracker.view.main.TransactionInput;

import javax.swing.*;
import java.awt.*;

class TransactionControllerImpl implements TransactionController {

    private Component parentComponent;
    private TransactionModel model;

    public TransactionControllerImpl(Component parentComponent, TransactionModel model) {
        this.parentComponent = parentComponent;
        this.model = model;
    }

    @Override
    public void newTransaction() {

        TransactionInput input = TransactionInput.newTransaction();

        int option = JOptionPane.showConfirmDialog(parentComponent, input.getRootPanel(), "New Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            Category category = input.getCategory();
            float amount = input.getAmount();
            long timeInMillis = input.getTimeInMillis();
            String description = input.getDescription();

            Transaction newTransaction = new Transaction(0,
                    Account.getInstance().getUserId(),
                    category.getId(),
                    amount,
                    timeInMillis,
                    description);
            model.add(newTransaction);
        }
    }

    @Override
    public void editTransaction(Transaction transaction) {

        TransactionInput input = TransactionInput.editTransaction(transaction);

        int option = JOptionPane.showConfirmDialog(parentComponent, input.getRootPanel(), "Edit Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            Category category = input.getCategory();
            float amount = input.getAmount();
            long timeInMillis = input.getTimeInMillis();
            String description = input.getDescription();

            transaction.setCategoryId(category.getId());
            transaction.setAmount(amount);
            transaction.setTimeInMillis(timeInMillis);
            transaction.setDescription(description);

            model.update(transaction);
        }
    }

    @Override
    public void deleteTransaction(int id) {

    }
}
