package app.moneytracker.controller;

import app.moneytracker.Account;
import app.moneytracker.model.User;
import app.moneytracker.model.UserModel;
import app.moneytracker.state.State;
import app.moneytracker.state.StateManager;
import app.moneytracker.view.signin.SignIn;
import app.moneytracker.view.signup.SignUp;

import javax.swing.*;
import java.awt.*;

public class SignInControllerImpl implements SignInController{

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
        String userName = view.getUsernameTxt();
        String password = view.getPasswordTxt();

        if (userName.trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent,"Username was not null","Something wrong here !! ",JOptionPane.OK_OPTION);
        }
        else if (password.trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent,"Password was not null","Something wrong here !! ",JOptionPane.OK_OPTION);
        }
        else
        {
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            boolean booleans = userModel.checkUserandPassword(user);
            if (!booleans)
            {
                JOptionPane.showMessageDialog(parent,"Username or password was wrong ","Something wrong here !! ",JOptionPane.OK_OPTION);
            }
            else {
                Account account = new Account();
                account.setUser(user);
                StateManager.getInstance().show(State.CATEGORY);
            }
        }

    }
}
