package app.moneytracker.view.signup;

import app.moneytracker.state.Pane;
import javax.swing.*;

public class SignUp extends Pane {

    private JPanel rootPanel;
    private JTextField UsernameTxt;
    private JPasswordField PasswordTxt;
    private JPasswordField CPasswordTxt;
    private JButton SignUpbtn;

    public SignUp(){
        setComponent(rootPanel);
    }

    @Override
    public void onPaneOpened() {

    }

    @Override
    public void onPaneClosed() {

    }
}
