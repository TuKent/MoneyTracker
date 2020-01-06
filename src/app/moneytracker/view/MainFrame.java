package app.moneytracker.view;

import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.moneytracker.view.category.CategoryState;
import app.moneytracker.view.intro.IntroState;
import app.moneytracker.view.main.MainState;
import app.moneytracker.view.signin.SignIn;
import app.moneytracker.view.signup.SignUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

        stateManager.show(State.INTRO);
    }

    private void initComponents() {

        initAllStates();

        initMenuBar();
    }

    private void initMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        initFileMenu(menuBar);
        initCategoryMenu(menuBar);

        setJMenuBar(menuBar);
    }

    private void initFileMenu(JMenuBar menuBar) {

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
    }

    private void initCategoryMenu(JMenuBar menuBar) {

        JMenu categoryMenu = new JMenu("Category");
        categoryMenu.setMnemonic(KeyEvent.VK_C);

        JMenuItem showMenuItem = new JMenuItem("Show", KeyEvent.VK_S);
        showMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
        showMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.CATEGORY);
            }
        });
        categoryMenu.add(showMenuItem);

        menuBar.add(categoryMenu);
    }

    private void initAllStates() {
        stateManager.add(State.INTRO, new IntroState());
        stateManager.add(State.SIGN_UP, new SignUp());
        stateManager.add(State.SIGN_IN, new SignIn());
        stateManager.add(State.MAIN, new MainState());
        stateManager.add(State.CATEGORY, new CategoryState());
    }
}
