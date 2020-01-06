package app.moneytracker.view.intro;

import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.util.Debug;

import javax.swing.*;

public class IntroState extends Pane {

    private static final String TAG = IntroState.class.getName();

    private JPanel rootPanel;

    public IntroState() {

        setComponent(rootPanel);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                StateManager.getInstance().show(State.SIGN_UP);
            }
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
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
