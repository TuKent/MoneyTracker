package app.moneytracker.model.category;

public class Category {

    int id;
    String name;
    boolean isExpense;

    public Category() {
    }

    public Category(int id, String name, boolean isExpense) {
        this.id = id;
        this.name = name;
        this.isExpense = isExpense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsExpense() {
        return isExpense;
    }

    public void setIsExpense(boolean isExpense) {
        this.isExpense = isExpense;
    }
}
