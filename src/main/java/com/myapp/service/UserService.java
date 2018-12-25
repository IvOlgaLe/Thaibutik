package com.myapp.service;

import com.myapp.DAO.RoleDAO;
import com.myapp.DAO.UserDAO;
import com.myapp.model.Role;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    public User saveUser(User user) {
        return userDAO.saveUser(user);
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

    public List<User> getUsersByParam(Map<String, Object> param) {
        return userDAO.getUsersByParam(param);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User validateUser(String email, String inputPassword) {
        return userDAO.validateUser(email, inputPassword);
    }

    public Role saveRole(Role role) {
        return roleDAO.saveRole(role);
    }

    public boolean deleteRoleById(int id) {
        return roleDAO.deleteRoleById(id);
    }

    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }
}
