package app.moneytracker.model.transaction;

import java.util.List;

public interface TransactionObserver {

    void onDataChanged(List<Transaction> transactions);
}
