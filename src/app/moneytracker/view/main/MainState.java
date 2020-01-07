package app.moneytracker.view.main;

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
    }

    private void onEditClicked(ActionEvent e) {
    }

    private void onDeleteClicked(ActionEvent e) {
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
