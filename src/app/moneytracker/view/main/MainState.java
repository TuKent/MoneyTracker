package app.moneytracker.view.main;

import app.moneytracker.Account;
import app.moneytracker.model.category.Category;
import app.moneytracker.model.transaction.Transaction;
import app.moneytracker.model.transaction.TransactionModel;
import app.moneytracker.model.transaction.TransactionModelImpl;
import app.moneytracker.state.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainState extends Pane {

    private static final String TAG = MainState.class.getName();

    private JPanel rootPanel;

    private JTable transactionTable;
    private TransactionTableModel transactionTableModel;

    private JButton deleteButton;
    private JButton editButton;
    private JButton newButton;

    private TransactionModel model;

    public MainState() {

        setComponent(rootPanel);

        initUiComponents();
    }

    private void initUiComponents() {

        model = new TransactionModelImpl();

        transactionTableModel = new TransactionTableModel();
        model.registerObserver(transactionTableModel);

        transactionTable.setModel(transactionTableModel);

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClicked(e);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClicked(e);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClicked(e);
            }
        });
    }

    private void onNewClicked(ActionEvent e) {

        TransactionInput input = TransactionInput.newTransaction();

        int option = JOptionPane.showConfirmDialog(rootPanel, input.getRootPanel(), "New Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {

            Category category = input.getCategory();
            float amount = input.getAmount();
            String description = input.getDescription();

            Transaction transaction = new Transaction(0,
                    Account.getInstance().getUserId(),
                    category.getId(),
                    amount,
                    0,
                    description);
            model.add(transaction);
        }
    }

    private void onEditClicked(ActionEvent e) {
    }

    private void onDeleteClicked(ActionEvent e) {
    }

    @Override
    public void onPaneOpened() {
        model.pull();
    }

    @Override
    public void onPaneClosed() {
    }
}
