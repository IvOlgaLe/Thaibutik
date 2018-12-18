package com.myapp.service;

import com.myapp.DAO.UserDAO;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUserById(int userId) {
        return userDAO.deleteUserById(userId);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getUsersByParam(Map<String, String> param) {
        return userDAO.getUsersByParam(param);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User validateUser(String email, String inputPassword) {
        return userDAO.validateUser(email, inputPassword);
    }
}
