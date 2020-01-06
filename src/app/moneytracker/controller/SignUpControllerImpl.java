package app.moneytracker.controller;

import app.moneytracker.model.User;
import app.moneytracker.model.UserModel;
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
        String fullName = view.getUsernameTxt();
        String password = view.getPasswordTxt();
        String cpassword = view.getCPasswordTxt();

        if (fullName.trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent,"Username was not null","Something wrong here !",JOptionPane.OK_OPTION);
        }
        else if (password.trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent,"Password was not null","Something wrong here !",JOptionPane.OK_OPTION);
        }
        else if (cpassword.trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent,"Confirm password was not null","Something wrong here",JOptionPane.OK_OPTION);
        }
        else if (!password.trim().equals(cpassword))
        {
            JOptionPane.showMessageDialog(parent,"Password do not match","Something wrong here !",JOptionPane.OK_OPTION);
        }
        else
        {
            User user = new User();
            user.setUsername(fullName);
            user.setPassword(password);
            userModel.add(user);
        }
    }
}
