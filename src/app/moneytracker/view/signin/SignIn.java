package app.moneytracker.view.signin;

import app.moneytracker.controller.signin.SignInController;
import app.moneytracker.controller.signin.SignInControllerImpl;
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
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton signinButton;
    private JButton signupButton;

    private UserModel usersModel;

    public SignIn() {
        setComponent(rootPanel);
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin(e);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.SIGN_UP);
            }
        });
    }

    private void onLogin(ActionEvent e) {
        usersModel = new UserModelImpl();
        SignInController controller = new SignInControllerImpl(rootPanel,usersModel,this);
        controller.oldMember();
    }

    public String getPasswordTextField() {
        return new String(usernameTextField.getText());
    }

    public String getUsernameTextField() {
        return new String(passwordTextField.getPassword());
    }


    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
