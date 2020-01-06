package app.moneytracker.view.category;

import app.moneytracker.state.Pane;
import app.util.Debug;

import javax.swing.*;

public class CategoryState extends Pane {

    private static final String TAG = CategoryState.class.getSimpleName();

    private JPanel rootPanel;

    public CategoryState() {
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
