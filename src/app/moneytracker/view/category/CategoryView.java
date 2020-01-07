package app.moneytracker.view.category;

import javax.swing.*;

public interface CategoryView {

    JPanel getRootPanel();

    String getName();

    boolean isExpense();
}
