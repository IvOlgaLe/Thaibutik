package com.myapp.DAOinterface;

import com.myapp.model.User;

import java.util.List;
import java.util.Map;

public interface UserDAOI {
    enum SQL {
        INSERT_USER("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?)"),       //8 items
        UPDATE_USER_BY_ID("UPDATE users SET name=:name, email=:email, password=:password, role_id=:roleId, " +
                "address=:address, phone=:phone, birthday=:birthday WHERE user_id=:userId"),
        GET_USER_BY_ID("SELECT * FROM users WHERE user_id = ?"),
        GET_USER_BY_EMAIL("SELECT * FROM users WHERE email = ?"),
        GET_ALL_USERS("SELECT * FROM users"),
        DELETE_USER_BY_ID("DELETE FROM users WHERE user_id = ?")
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

    User updateUser(User user);

    boolean deleteUserById(int userId);

    User getUserById(int userId);

    User getUserByEmail(String email);

    List<User> getUsersByParam(Map<String, String> param);

    List<User> getAllUsers();
}
