package app.moneytracker.view.signin;

import app.moneytracker.state.Pane;

import javax.swing.*;

public class SignIn extends Pane {

    private JPanel rootPanel;
    private JTextField UsernameTxt;
    private JPasswordField PasswordTxt;
    private JButton SignInBtn;

    public SignIn() {
        setComponent(rootPanel);
    }


    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
