package app.moneytracker.model.transaction;

import app.moneytracker.model.Database;
import app.util.Debug;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private static final String TAG = TransactionDao.class.getSimpleName();

    @Override
    public void insert(Transaction transaction) {

        Database db = new Database();
        String SQL_INSERT_TRANSACTION = "INSERT INTO Transactions(UserId,CategoryId,Amount,TimeInMillis,Description) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_TRANSACTION, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, transaction.getUserId());
            ps.setInt(2, transaction.getCategoryId());
            ps.setFloat(3, transaction.getAmount());
            ps.setLong(4, transaction.getTimeInMillis());
            ps.setString(5, transaction.getDescription());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                transaction.setId(id);
                Debug.i(TAG, "Inserted Category id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void update(Transaction transaction) {

        Database db = new Database();
        final String SQL_UPDATE_TRANSACTION_BY_ID = "UPDATE Transactions " +
                "SET CategoryId = ?, " +
                "Amount = ?," +
                "TimeInMillis = ?," +
                "Description = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_TRANSACTION_BY_ID);
            ps.setInt(1, transaction.getCategoryId());
            ps.setFloat(2, transaction.getAmount());
            ps.setLong(3, transaction.getTimeInMillis());
            ps.setString(4, transaction.getDescription());
            ps.setInt(5, transaction.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void delete(int id) {

        Database db = new Database();
        final String SQL_DELETE_TRANSACTION_BY_ID = "DELETE FROM Transactions WHERE ID=?";

        try
        {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_TRANSACTION_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();

            Debug.i(TAG, "Deleted Category id: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();
        Database db = new Database();

        final String SQL_SELECT_ALL_TRANSACTIONS = "SELECT * FROM Transactions";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_TRANSACTIONS);
            while (rs.next()) {
                int id = rs.getInt(1);
                int userId = rs.getInt(2);
                int categoryId = rs.getInt(3);
                float amount = rs.getFloat(4);
                long timeInSeconds = rs.getLong(5);
                String description = rs.getString(6);

                Transaction t = new Transaction(id, userId, categoryId, amount, timeInSeconds, description);
                transactions.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
        return transactions;
    }
}
