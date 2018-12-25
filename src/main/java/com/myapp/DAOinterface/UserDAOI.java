package com.myapp.DAOinterface;

import com.myapp.model.User;

import java.util.List;
import java.util.Map;

public interface UserDAOI {
    enum SQL {
        UPDATE_USER_BY_ID("UPDATE users SET name=:name, email=:email, password=:password, role_id=:role_id, " +
                "address=:address, phone=:phone, birthday=:birthday WHERE id=:id"),
        DELETE_USER_BY_ID("DELETE FROM users WHERE id = ?"),
        GET_USER_BY_ID("SELECT * FROM users WHERE id = ?"),
        GET_USER_BY_EMAIL("SELECT * FROM users WHERE email = ?"),
        GET_USER_BY_PARAM(
                "SELECT * FROM users " +
                "WHERE 1 = 1 "),
        PARAM_NAME(
                "AND UPPER(name) LIKE ? "),
        PARAM_ADDRESS(
                "AND UPPER(address) LIKE ? "),
        PARAM_ROLE_ID(
                "AND role_id = ? "),
        PARAM_PHONE(
                "AND phone LIKE ? "),
        PARAM_BIRTHDAY(
                "AND birthday = ? ")
        ;

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    User saveUser(User user);

    boolean deleteUserById(int id);

    User getUserById(int id);

    User getUserByEmail(String email);

    List<User> getUsersByParam(Map<String, Object> param);

    List<User> getAllUsers();
}
