package app.moneytracker.view.signin;

import app.moneytracker.controller.SignInController;
import app.moneytracker.controller.SignInControllerImpl;
import app.moneytracker.controller.SignUpController;
import app.moneytracker.controller.SignUpControllerImpl;
import app.moneytracker.model.UserModel;
import app.moneytracker.model.UserModelImpl;
import app.moneytracker.state.Pane;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends Pane {

    private JPanel rootPanel;
    private JTextField UsernameTxt;
    private JPasswordField PasswordTxt;
    private JButton SignInBtn;
    private JButton SignUpBtn;

    private UserModel usersModel;

    public SignIn() {
        setComponent(rootPanel);
        SignInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin(e);
            }
        });

        SignUpBtn.addActionListener(new ActionListener() {
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

    public String  getPasswordTxt() {
        return new String(UsernameTxt.getText());
    }

    public String getUsernameTxt() {
        return new String(PasswordTxt.getPassword());
    }


    @Override
    public void onPaneOpened() {
    }

    @Override
    public void onPaneClosed() {
    }
}
