package com.myapp.DAOinterface;

import com.myapp.model.Category;

import java.util.List;

public interface CategoryDAOI {
    enum SQL {
        UPDATE_CATEGORY_BY_ID("UPDATE category SET name=:name, description:=description WHERE id = ?"),
        GET_CATEGORY_BY_ID("SELECT * FROM category WHERE id = ?"),
        GET_CATEGORY_BY_NAME("SELECT * FROM category WHERE name = ?"),
        GET_ALL_CATEGORIES("SELECT * FROM category"),
        DELETE_CATEGORY_BY_ID("DELETE FROM category WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public Category saveCategory(Category category);

    public Category getCategoryById(int id);

    public boolean deleteCategoryById(int id);

    Category getCategoryByName(String name);

    public List<Category> getAllCategorys();
}
