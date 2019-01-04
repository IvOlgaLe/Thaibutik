package com.myapp.DAOinterface;

import com.myapp.model.Group;

import java.util.List;

public interface GroupDAOI {
    enum SQL {
        UPDATE_GROUP_BY_ID("UPDATE groups SET name=:name, description=:description WHERE id=:id"),
        GET_GROUP_BY_ID(
                "SELECT g.id AS group_id, g.name AS group_name, g.description AS group_description, " +
                        "c.id AS category_id, c.name AS category_name, c.description AS category_description " +
                        "FROM groups g " +
                        "LEFT JOIN group_category gc ON g.id = gc.group_id " +
                        "LEFT JOIN category c ON c.id = gc.category_id " +
                        "WHERE g.id = ?"),
        GET_GROUP_BY_NAME(
                "SELECT g.id AS group_id, g.name AS group_name, g.description AS group_description, " +
                        "c.id AS category_id, c.name AS category_name, c.description AS category_description " +
                        "FROM groups g " +
                        "LEFT JOIN group_category gc ON g.id = gc.group_id " +
                        "LEFT JOIN category c ON c.id = gc.category_id " +
                        "WHERE g.name LIKE ?"),
        GET_ALL_GROUPS(
                "SELECT g.id AS group_id, g.name AS group_name, g.description AS group_description, " +
                        "c.id AS category_id, c.name AS category_name, c.description AS category_description " +
                        "FROM groups g " +
                        "LEFT JOIN group_category gc ON g.id = gc.group_id " +
                        "LEFT JOIN category c ON c.id = gc.category_id "),
        DELETE_GROUP_BY_ID("DELETE FROM groups WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public Group saveGroup(Group group);

    public Group getGroupById(int id);

    public boolean deleteGroupById(int id);

    List<Group> getGroupByName(String name);

    public List<Group> getAllGroups();
}
