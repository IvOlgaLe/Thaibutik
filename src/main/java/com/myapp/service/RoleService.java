package com.myapp.service;

import com.myapp.DAO.RoleDAO;
import com.myapp.DAO.UserDAO;
import com.myapp.model.Role;
import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role saveRole(Role role) {
        return roleDAO.saveRole(role);
    }

    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    public String getRoleNameById(int id) {
        return roleDAO.getRoleById(id).getName();
    }

    public boolean deleteRoleById(int id) {
        return roleDAO.deleteRoleById(id);
    }

    public int getRoleIdByName(String name) {
        return roleDAO.getRoleByName(name).getId();
    }

    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }


}
