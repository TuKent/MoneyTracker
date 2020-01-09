package app.moneytracker.view.main;

import app.moneytracker.controller.transaction.TransactionController;
import app.moneytracker.controller.transaction.TransactionControllerFactory;
import app.moneytracker.model.transaction.Transaction;
import app.moneytracker.model.transaction.TransactionModel;
import app.moneytracker.model.transaction.TransactionModelImpl;
import app.moneytracker.state.Pane;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
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

        model = new TransactionModelImpl();

        setComponent(rootPanel);

        initUiComponents();
    }

    private void initUiComponents() {

        initTransactionTable();

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

    private void initTransactionTable() {

        transactionTableModel = new TransactionTableModel();
        model.registerObserver(transactionTableModel);

        transactionTable.setModel(transactionTableModel);

        transactionTable.getTableHeader().setReorderingAllowed(false);

        TableColumnModel columnModel = transactionTable.getColumnModel();
        columnModel.getColumn(TransactionTableModel.CATEGORY_TYPE).setMaxWidth(20);

        DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
        alignCenter.setHorizontalAlignment(JLabel.CENTER);
        transactionTable.getColumnModel().getColumn(TransactionTableModel.CATEGORY_TYPE).setCellRenderer(alignCenter);

        DefaultTableCellRenderer alignLeft = new DefaultTableCellRenderer();
        alignLeft.setHorizontalAlignment(JLabel.CENTER);
        transactionTable.getColumnModel().getColumn(TransactionTableModel.AMOUNT).setCellRenderer(alignCenter);
    }

    private void onNewClicked(ActionEvent e) {
        TransactionController controller = TransactionControllerFactory.newInstance(rootPanel, model);
        controller.newTransaction();
    }

    private void onEditClicked(ActionEvent e) {

        int rowIndex = transactionTable.getSelectedRow();
        if (rowIndex != -1) {
            Transaction transaction = transactionTableModel.getTransaction(rowIndex);
            TransactionController controller = TransactionControllerFactory.newInstance(rootPanel, model);
            controller.editTransaction(transaction);
        }
    }

    private void onDeleteClicked(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(rootPanel,"Do you want to delete this Category ? ","Delete Category",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_NO_OPTION)
        {
            int rowIndex = transactionTable.getSelectedRow();
            if (rowIndex != -1) {
                Transaction transaction = transactionTableModel.getTransaction(rowIndex);
                model.remove(transaction.getId());
            }
        }
    }


    @Override
    public void onPaneOpened() {
        model.pull();
    }

    @Override
    public void onPaneClosed() {
    }
}
