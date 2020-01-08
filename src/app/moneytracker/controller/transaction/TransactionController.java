package app.moneytracker.controller.transaction;

import app.moneytracker.model.transaction.Transaction;

public interface TransactionController {

    void newTransaction();

    void editTransaction(Transaction transaction);

    void deleteTransaction(int id);
}
