package app.moneytracker.view;

import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.moneytracker.view.action.ActionState;
import app.moneytracker.view.intro.IntroState;
import app.moneytracker.view.main.MainState;
import app.moneytracker.view.signin.SignIn;
import app.moneytracker.view.signup.SignUp;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel rootPanel;
    private JPanel contentPanel;

    private final StateManager stateManager;

    public MainFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);

        stateManager = StateManager.getInstance();
        stateManager.initiate(contentPanel);

        initComponents();

        open(State.INTRO);
    }

    private void initComponents() {

        stateManager.add(State.INTRO, new IntroState());
        stateManager.add(State.SIGN_UP, new SignUp());
        stateManager.add(State.SIGN_IN, new SignIn());
        stateManager.add(State.MAIN, new MainState());
        stateManager.add(State.ACTION, new ActionState());
    }

    public void open(final State state) {
        stateManager.show(state);
    }
}
