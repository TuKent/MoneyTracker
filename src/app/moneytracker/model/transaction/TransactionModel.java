package app.moneytracker.model.transaction;

import java.util.List;

public interface TransactionModel {

    void pull();

    void add(Transaction transaction);

    void update(Transaction transaction);

    void remove(int id);

    List<Transaction> getAllTransactions();

    void registerObserver(TransactionObserver observer);

    void unregisterObserver(TransactionObserver observer);
}
