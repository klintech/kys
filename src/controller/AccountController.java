package src.controller;

import java.sql.SQLException;

import src.dao.AccountDAO;
import src.model.Account;

public class AccountController {
    private AccountDAO dao;
    
    public AccountController() {
        dao = new AccountDAO();
    }
    
    public void addCategory(Account a) {
        try {
            dao.insert(a);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAccounts() {
        try {
            dao.getAll();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(Account a) {
        try {
            dao.update(a);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int id) {
        try {
            dao.delete(id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
