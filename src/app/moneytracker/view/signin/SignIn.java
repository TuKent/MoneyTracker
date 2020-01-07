package app.moneytracker.view.signin;

import app.moneytracker.Account;
import app.moneytracker.model.user.User;
import app.moneytracker.model.user.UserModel;
import app.moneytracker.model.user.UserModelImpl;
import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends Pane {

    private JPanel rootPanel;

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton signInButton;
    private JButton signUpButton;

    public SignIn() {

        setComponent(rootPanel);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSignInClicked(e);
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSignUpClicked(e);
            }
        });
    }

    private void onSignInClicked(ActionEvent e) {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        UserModel model = new UserModelImpl();
        User user = model.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                Account.getInstance().setUser(user);
                StateManager.getInstance().show(State.MAIN);
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Incorrect password!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPanel, "Account not found!");
        }
    }

    private void onSignUpClicked(ActionEvent e) {
        StateManager.getInstance().show(State.SIGN_UP);
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
