package app.moneytracker.model.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void insert(Transaction transaction) {
    }

    @Override
    public void update(Transaction transaction) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}
