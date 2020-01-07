package app.moneytracker.controller.signin;

import app.moneytracker.Account;
import app.moneytracker.model.user.User;
import app.moneytracker.model.user.UserModel;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.moneytracker.view.signin.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInControllerImpl implements SignInController {

    private Component parent;

    private UserModel userModel;

    private SignIn view;

    public SignInControllerImpl(Component parent, UserModel userModel, SignIn view) {
        this.parent = parent;
        this.userModel = userModel;
        this.view = view;
    }

    @Override
    public void oldMember() {
        String userName = view.getUsernameTextField();
        String password = view.getPasswordTextField();

        if (userName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Username was not null", "Something wrong here !! ", JOptionPane.OK_OPTION);
        } else if (password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Password was not null", "Something wrong here !! ", JOptionPane.OK_OPTION);
        } else {
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            boolean booleans = userModel.checkAccount(user);
            if (!booleans) {
                JOptionPane.showMessageDialog(parent, "Username or password was wrong ", "Something wrong here !! ", JOptionPane.OK_OPTION);
            } else {
                Account account = new Account();
                account.setUser(user);
                StateManager.getInstance().show(State.CATEGORY);
            }
        }

    }
}
