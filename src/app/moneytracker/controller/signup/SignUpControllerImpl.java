package app.moneytracker.controller.signup;

import app.moneytracker.Account;
import app.moneytracker.model.user.User;
import app.moneytracker.model.user.UserModel;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.moneytracker.view.signup.SignUp;

import javax.swing.*;
import java.awt.*;

public class SignUpControllerImpl implements SignUpController {

    private Component parent;

    private UserModel userModel;

    private SignUp view;

    public SignUpControllerImpl(Component parent, UserModel userModel, SignUp view) {
        this.parent = parent;
        this.userModel = userModel;
        this.view = view;
    }

    @Override
    public void newMember() {
        String fullName = view.getUsernameTextField();
        String password = view.getPasswordTextField();
        String cpassword = view.getConfirmpassword();

        if (fullName.trim().equals("")) {
            JOptionPane.showMessageDialog(parent, "Username was not null", "Something wrong here !", JOptionPane.OK_OPTION);
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(parent, "Password was not null", "Something wrong here !", JOptionPane.OK_OPTION);
        } else if (cpassword.trim().equals("")) {
            JOptionPane.showMessageDialog(parent, "Confirm password was not null", "Something wrong here", JOptionPane.OK_OPTION);
        } else if (!password.trim().equals(cpassword)) {
            JOptionPane.showMessageDialog(parent, "Password do not match", "Something wrong here !", JOptionPane.OK_OPTION);
        } else {
            User user = new User();
            user.setUsername(fullName);
            user.setPassword(password);
            userModel.add(user);
            Account account = new Account();
            account.setUser(user);
            StateManager.getInstance().show(State.MAIN);
        }
    }
}
