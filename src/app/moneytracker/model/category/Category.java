package app.moneytracker.model.category;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Category category = (Category) o;
        return id == category.id &&
                isExpense == category.isExpense &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isExpense);
    }
}
