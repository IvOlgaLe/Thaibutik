package com.myapp.DAO;

import com.myapp.DAOinterface.GroupDAOI;
import com.myapp.model.Category;
import com.myapp.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupDAO implements GroupDAOI {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertGroup;

    @Autowired
    public GroupDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertGroup = new SimpleJdbcInsert(dataSource)
                .withTableName("groups")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private class MyObjectExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Group> map = new HashMap<Integer, Group>();
            List<Group> resultList = new ArrayList<Group>();
            while (rs.next()) {
                Integer group_id = rs.getInt("group_id");
                Group group = map.get(group_id);
                if (group == null) {
                    group = new Group();
                }
                if (!resultList.contains(group)) {
                    resultList.add(group);
                }

                group.setId(group_id);
                group.setName(rs.getString("group_name"));
                group.setDescription(rs.getString("group_description"));

                map.put(group_id, group);

                int categoryId = rs.getInt("category_id");
                if (categoryId != 0) {
                    List<Category> categoryList = group.getCategoryList();
                    if (categoryList == null) {
                        categoryList = new ArrayList<Category>();
                    }
                    Category category= new Category();
                    category.setId(categoryId);
                    category.setName(rs.getString("category_name"));
                    category.setDescription(rs.getString("category_description"));

                    categoryList.add(category);
                    group.setCategoryList(categoryList);
                }
            }
            return resultList;
        }
    }

    private final MyObjectExtractor MY_OBJECT_EXTRACTOR = new MyObjectExtractor();
    
    @Override
    public Group saveGroup(Group group) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", group.getId())
                .addValue("name", group.getName())
                .addValue("description", group.getDescription())
                ;

        if (group.isNew()) {
            Number newKey = insertGroup.executeAndReturnKey(map);
            group.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_GROUP_BY_ID.getQuery(), map);
        }
        return group;
    }

    @Override
    public List<Group> getAllGroups() {
        return (List<Group>) jdbcTemplate.query(SQL.GET_ALL_GROUPS.getQuery(), MY_OBJECT_EXTRACTOR);
    }

    @Override
    public Group getGroupById(int id) {
        List<Group> categories = (List<Group>) jdbcTemplate.query(SQL.GET_GROUP_BY_ID.getQuery(), MY_OBJECT_EXTRACTOR, id);
        return DataAccessUtils.singleResult(categories);
    }

    @Override
    public List<Group> getGroupByName(String name) {
        return (List<Group>) jdbcTemplate.query(SQL.GET_GROUP_BY_NAME.getQuery(), MY_OBJECT_EXTRACTOR, "%" + name + "%");
    }

    @Override
    public boolean deleteGroupById(int id) {
        return jdbcTemplate.update(SQL.DELETE_GROUP_BY_ID.getQuery(), id) != 0;
    }
}
