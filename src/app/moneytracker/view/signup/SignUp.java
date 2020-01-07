package app.moneytracker.view.signup;

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

public class SignUp extends Pane {

    private JPanel rootPanel;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton cancelButton;
    private JButton OKButton;

    public SignUp() {

        setComponent(rootPanel);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOKClicked(e);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancelClicked(e);
            }
        });
    }

    private void onOKClicked(ActionEvent e) {

        String username = usernameField.getText();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(rootPanel, "User name must not empty!");
            return;
        }

        String password = new String(passwordField.getPassword());
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(rootPanel, "Password must not empty!");
            return;
        }

        String confirmPassword = new String(confirmPasswordField.getPassword());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(rootPanel, "Password and Confirm Password not same!");
            return;
        }

        UserModel model = new UserModelImpl();
        User user = model.getUser(username);
        if (user == null) {
            User newUser = new User(username, password);
            model.add(newUser);
            Account.getInstance().setUser(newUser);
            StateManager.getInstance().show(State.MAIN);
        } else {
            JOptionPane.showMessageDialog(rootPanel, "Account already existed!");
        }
    }

    private void onCancelClicked(ActionEvent e) {
        StateManager.getInstance().show(State.SIGN_IN);
    }

    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
