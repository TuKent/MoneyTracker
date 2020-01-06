package app.moneytracker.view.signup;

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

public class SignUp extends Pane {

    private JPanel rootPanel;

    private JTextField UsernameTxt;
    private JPasswordField PasswordTxt;
    private JPasswordField CPasswordTxt;
    private JButton SignUpBtn;
    private JButton SignInBtn;

    private UserModel usersModel;

    public SignUp(){
        setComponent(rootPanel);
        SignUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegister(e);
            }
        });
        SignInBtn.addActionListener(new ActionListener() {
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

    public String getUsernameTxt() {
        return new String(UsernameTxt.getText());
    }

    public String getPasswordTxt() {
        return new String(PasswordTxt.getPassword());
    }

    public String getCPasswordTxt() {
                        return new String(CPasswordTxt.getPassword());
    }


    @Override
    public void onPaneOpened() {

    }

    @Override
    public void onPaneClosed() {

    }
}
