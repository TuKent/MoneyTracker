package app.moneytracker.view.main;

import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainState extends Pane {

    private static final String TAG = MainState.class.getName();

    private JPanel rootPanel;
    private JButton actionButton;
    private JButton loadButton;
    private JButton settingsButton;
    private JButton exitButton;

    public MainState() {

        setComponent(rootPanel);

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onActionClicked(e);
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoadClicked(e);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSettingsClicked(e);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExitClicked(e);
            }
        });
    }

    @Override
    public void onPaneOpened() {
        System.out.println(TAG + " - onPaneOpened");
    }

    @Override
    public void onPaneClosed() {
        System.out.println(TAG + " - onPaneClosed");
    }

    private void onActionClicked(ActionEvent e) {
        StateManager.getInstance().show(State.ACTION);
    }

    private void onLoadClicked(ActionEvent e) {
    }

    private void onSettingsClicked(ActionEvent e) {
    }

    private void onExitClicked(ActionEvent e) {
        System.exit(0);
    }
}
