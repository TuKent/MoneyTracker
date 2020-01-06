package app.moneytracker.view.signup;

import app.moneytracker.controller.signup.SignUpController;
import app.moneytracker.controller.signup.SignUpControllerImpl;
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

    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JPasswordField confirmpasswordTextField;
    private JButton signupButton;
    private JButton signinButton;

    private UserModel usersModel;

    public SignUp(){
        setComponent(rootPanel);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegister(e);
            }
        });
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.getInstance().show(State.SIGN_IN);
            }
        });
    }

    private void onRegister(ActionEvent e) {
        usersModel = new UserModelImpl();
        SignUpController controller = new SignUpControllerImpl(rootPanel,usersModel,this);
        controller.newMember();
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public String getPasswordTextField() {
        return new String(passwordTextField.getPassword());
    }

    public String getConfirmpassword() {
                        return new String(confirmpasswordTextField.getPassword());
    }


    @Override
    public void onPaneOpened() {

    }

    @Override
    public void onPaneClosed() {

    }
}
