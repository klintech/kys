package src.controller;

import java.sql.SQLException;

import src.dao.CategoryDAO;
import src.model.Category;

public class CategoryController {
    private CategoryDAO dao;
    
    public CategoryController() {
        dao = new CategoryDAO();
    }
    
    public void addCategory(Category c) {
        try {
            dao.insert(c);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCategories() {
        try {
            dao.getAll();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(Category c) {
        try {
            dao.update(c);
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