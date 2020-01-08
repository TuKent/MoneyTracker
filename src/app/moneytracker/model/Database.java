package app.moneytracker.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private final static String DB_PATH = "moneytracker.db";

    private Connection connection;

    public Database() {

        final String url = "jdbc:sqlite:" + DB_PATH;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void initiate() {

        final String SQL_CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    Username text NOT NULL,\n"
                + "    Password text NOT NULL\n"
                + ");";

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE IF NOT EXISTS Categories (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    Name text NOT NULL,\n"
                + "    IsExpense integer NOT NULL\n"
                + ");";

        final String SQL_CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS Transactions (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    UserId integer NOT NULL,\n"
                + "    CategoryId integer NOT NULL,\n"
                + "    Amount real NOT NULL,\n"
                + "    TimeInMillis integer NOT NULL,\n"
                + "    Description text NOT NULL\n"
                + ");";

        try {
            Statement statement = getConnection().createStatement();
            statement.execute(SQL_CREATE_USERS_TABLE);
            statement.execute(SQL_CREATE_CATEGORIES_TABLE);
            statement.execute(SQL_CREATE_TRANSACTIONS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {

        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
