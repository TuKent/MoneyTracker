package app.moneytracker.view.category;

import javax.swing.*;

public class CategoryInput implements CategoryView {

    private JPanel rootPanel;

    private JTextField nameTextField;
    private JRadioButton incomeRadioButton;
    private JRadioButton expenseRadioButton;

    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public String getName() {
        return nameTextField.getText();
    }

    @Override
    public boolean isExpense() {
        return expenseRadioButton.isSelected();
    }
}
