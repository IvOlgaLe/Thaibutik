package com.myapp.DAOinterface;

import com.myapp.model.Role;

import java.util.List;

public interface RoleDAOI {
    enum SQL {
        UPDATE_ROLE_BY_ID("UPDATE role SET name=:name WHERE id=:id"),
        GET_ROLE_BY_ID("SELECT * FROM role WHERE id = ?"),
        GET_ROLE_BY_NAME("SELECT * FROM role WHERE name = ?"),
        GET_ALL_ROLES("SELECT * FROM role"),
        DELETE_ROLE_BY_ID("DELETE FROM role WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public Role saveRole(Role role);

    public Role getRoleById(int id);

    public boolean deleteRoleById(int id);

    Role getRoleByName(String name);

    public List<Role> getAllRoles();
}
