package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.model.Account;

public class AccountDAO {

    public void insert(Account a) throws SQLException {
        String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getName());
            stmt.setBigDecimal(2, a.getBalance());
            stmt.executeUpdate();
        }
    }

    public List<Account> getAll() throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts ORDER BY id ASC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account a = new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("balance"));
                list.add(a);
            }
        }
        return list;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM accounts WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void update(Account a) throws SQLException {
        String sql = "UPDATE accounts SET name=?, balance=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getName());
            stmt.setBigDecimal(2, a.getBalance());
            stmt.setInt(3, a.getId());
            stmt.executeUpdate();
        }
    }
}
