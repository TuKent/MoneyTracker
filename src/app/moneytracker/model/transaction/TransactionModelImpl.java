package app.moneytracker.model.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionModelImpl implements TransactionModel {

    private List<TransactionObserver> observers = new ArrayList<>();

    @Override
    public void pull() {
        notifyObservers();
    }

    @Override
    public void add(Transaction transaction) {
        TransactionDao dao = new TransactionDaoImpl();
        dao.insert(transaction);
        notifyObservers();
    }

    @Override
    public void update(Transaction transaction) {
        TransactionDao dao = new TransactionDaoImpl();
        dao.update(transaction);
        notifyObservers();
    }

    @Override
    public void remove(int id) {
        TransactionDao dao = new TransactionDaoImpl();
        dao.delete(id);
        notifyObservers();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        TransactionDao dao = new TransactionDaoImpl();
        return dao.getAllTransactions();
    }

    @Override
    public void registerObserver(TransactionObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(TransactionObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {

        TransactionDao dao = new TransactionDaoImpl();
        List<Transaction> transactions = dao.getAllTransactions();
        for (TransactionObserver observer: observers) {
            observer.onDataChanged(transactions);
        }
    }
}
