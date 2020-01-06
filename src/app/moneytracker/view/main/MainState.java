package app.moneytracker.view.main;

import app.moneytracker.state.Pane;
import app.util.Debug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainState extends Pane {

    private static final String TAG = MainState.class.getName();

    private JPanel rootPanel;
    private JTable transactionTable;
    private JButton deleteButton;
    private JButton editButton;
    private JButton newButton;

    public MainState() {

        setComponent(rootPanel);
    }

    private void initUiComponents() {

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
        Debug.i(TAG, "onPaneOpened()");
    }

    @Override
    public void onPaneClosed() {
        Debug.i(TAG, "onPaneClosed()");
    }
}
