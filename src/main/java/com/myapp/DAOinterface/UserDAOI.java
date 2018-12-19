package com.myapp.DAOinterface;

import com.myapp.model.User;

import java.util.List;
import java.util.Map;

public interface UserDAOI {
    enum SQL {
/*        INSERT_USER("INSERT INTO users(name, email, password, role_id, address, phone, birthday)" +
                "VALUES (:name, :email, :password, :roleId, :address, :phone, :birthday)"),       //7 items*/
        UPDATE_USER_BY_ID("UPDATE users SET name=:name, email=:email, password=:password, role_id=:role_id, " +
                "address=:address, phone=:phone, birthday=:birthday WHERE id=:id"),
        GET_USER_BY_ID("SELECT * FROM users WHERE id = ?"),
        GET_USER_BY_EMAIL("SELECT * FROM users WHERE email = ?"),
        GET_ALL_USERS("SELECT * FROM users"),
        DELETE_USER_BY_ID("DELETE FROM users WHERE id = ?")
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

    List<User> getUsersByParam(Map<String, String> param);

    List<User> getAllUsers();
}
