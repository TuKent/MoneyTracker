package app.moneytracker.view.category;

import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryState extends Pane {

    private static final String TAG = CategoryState.class.getSimpleName();

    private JPanel rootPanel;
    private JTable categoryTable;
    private CategoryTableModel categoryTableModel;
    private JButton deleteButton;
    private JButton editButton;
    private JButton newButton;
    private JButton backToHomeButton;

    public CategoryState() {

        setComponent(rootPanel);
        initUiComponents();
    }

    private void initUiComponents() {

        categoryTableModel = new CategoryTableModel();
        categoryTable.setModel(categoryTableModel);

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

        backToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.MAIN);
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
