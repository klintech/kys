package src.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import src.dao.TransactionDAO;
import src.model.Transaction;

public class TransactionController {
    private TransactionDAO dao;

    public TransactionController() {
        this.dao = new TransactionDAO();
    }

    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return transactions;
    }

    public void addTransaction(Transaction t) {
        try {
            dao.insert(t);
        } catch (SQLException e) {
            e.printStackTrace(); // show in gui
        }
    }
    
    public void updateTransaction(Transaction t) {
        try {
            dao.update(t);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(int id) {
        try {
            dao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
