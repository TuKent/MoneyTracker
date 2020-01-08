package app.moneytracker.controller.transaction;

import app.moneytracker.model.transaction.TransactionModel;

import java.awt.*;

public class TransactionControllerFactory {

    private TransactionControllerFactory() {
    }

    public static TransactionController newInstance(Component parentComponent, TransactionModel model) {
        return new TransactionControllerImpl(parentComponent, model);
    }
}
