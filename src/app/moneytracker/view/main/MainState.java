package app.moneytracker.view.main;

import app.moneytracker.state.Pane;
import app.util.Debug;

import javax.swing.*;

public class MainState extends Pane {

    private static final String TAG = MainState.class.getName();

    private JPanel rootPanel;

    public MainState() {

        setComponent(rootPanel);
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
