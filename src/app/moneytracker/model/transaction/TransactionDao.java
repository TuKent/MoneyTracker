package app.moneytracker.model.transaction;

import java.util.List;

public interface TransactionDao {

    void insert(Transaction transaction);

    void update(Transaction transaction);

    void delete(int id);

    List<Transaction> getAllTransactions();
}
