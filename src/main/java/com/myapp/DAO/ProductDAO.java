package com.myapp.DAO;

import com.myapp.DAOinterface.ProductDAOI;
import com.myapp.model.Brand;
import com.myapp.model.Item;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProductDAO extends BaseDAO implements ProductDAOI {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertProduct;

    @Autowired
    public ProductDAO(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertProduct = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private class MyObjectExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, Product> map = new HashMap<Integer, Product>();
            List<Product> resultList = new ArrayList<Product>();
            while (rs.next()) {
                Integer product_id = rs.getInt("product_id");
                Product product = map.get(product_id);
                if (product == null) {
                    product = new Product();
                }
                if(!resultList.contains(product)) {
                    resultList.add(product);
                }

                product.setId(product_id);
                product.setName(rs.getString("name"));
                product.setImageSource(rs.getString("image_source"));
                product.setDescription(rs.getString("description"));

                Brand brand = new Brand();
                brand.setId(rs.getInt("brand_id"));
                brand.setName(rs.getString("brand_name"));
                brand.setDescription(rs.getString("brand_description"));

                product.setBrand(brand);
                map.put(product_id, product);

                List<Item> itemList = product.getItemList();
                if (itemList == null) {
                    itemList = new ArrayList<>();
                }
                Item item = new Item();
                item.setId(rs.getInt("item_id"));
                item.setCurrencyId(rs.getInt("currency_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setQuantOrdered(rs.getInt("quant_ordered"));
                item.setDiscount(rs.getInt("discount"));
                item.setPrice(rs.getBigDecimal("price"));
                item.setItemType(rs.getString("item_type"));
                item.setItemSize(rs.getString("item_size"));
                item.setImageSource(rs.getString("item_image_source"));
                item.setAvailable(rs.getBoolean("available"));
                itemList.add(item);
                product.setItemList(itemList);
            }
            return resultList;
        }

    }

    private final MyObjectExtractor MY_OBJECT_EXTRACTOR = new MyObjectExtractor();

    @Override
    public Product saveProduct(Product product) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", product.getId())
                .addValue("name", product.getName())
                .addValue("brand_id", product.getBrand().getId())
                .addValue("image_source", product.getImageSource())
                .addValue("description", product.getDescription());

        if (product.isNew()) {
            Number newKey = insertProduct.executeAndReturnKey(map);
            product.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(SQL.UPDATE_PRODUCT_BY_ID.getQuery(), map);
        }
        return product;
    }

    @Override
    public boolean deleteProductById(int id) {
        return jdbcTemplate.update(SQL.DELETE_PRODUCT_BY_ID.getQuery(), id) != 0;
    }

    @Override
    public Product getProductById(int id) {
        List<Product> products = (List<Product>) jdbcTemplate.query(SQL.GET_PRODUCT_BY_ID.getQuery(), MY_OBJECT_EXTRACTOR, id);
        return DataAccessUtils.singleResult(products);
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        return (List<Product>) jdbcTemplate.query(SQL.GET_PRODUCT_BY_CAT_PARAM.getQuery(), MY_OBJECT_EXTRACTOR, categoryId);
    }

    @Override
    public List<Product> getProductByParam(Map<String, Object> param) {
        String query;
        List<Object> argsList = new ArrayList<>();
        if (param.get("categoryId") != null) {
            query = SQL.GET_PRODUCT_BY_CAT_PARAM.getQuery();
            argsList.add(param.get("categoryId"));
        } else {
            query = SQL.GET_PRODUCT_BY_PARAM.getQuery();
        }
        if (param.get("name") != null) {
            query = query + SQL.PARAM_NAME.getQuery();
            argsList.add("%" + param.get("name").toString().toUpperCase() + "%");
        }
        if (param.get("brandId") != null) {
            query = query + SQL.PARAM_BRAND_ID.getQuery();
            argsList.add(param.get("brandId"));
        }
        if (param.get("itemType") != null) {
            query = query + SQL.PARAM_ITEM_TYPE.getQuery();
            argsList.add("%" + param.get("itemType").toString().toUpperCase() + "%");
        }
        if (param.get("itemSize") != null) {
            query = query + SQL.PARAM_ITEM_SIZE.getQuery();
            argsList.add(param.get("itemSize").toString().toUpperCase());
        }
        if (param.get("lowPrice") != null) {
            query = query + SQL.PARAM_LOW_PRICE.getQuery();
            argsList.add(param.get("lowPrice"));
        }
        if (param.get("highPrice") != null) {
            query = query + SQL.PARAM_HIGH_PRICE.getQuery();
            argsList.add(param.get("highPrice"));
        }
        if (param.get("orderBy") != null) {
            query = query + "ORDER BY " + param.get("orderBy");
        }
        Object[] args = argsList.toArray();
        return (List<Product>) jdbcTemplate.query(query, MY_OBJECT_EXTRACTOR, args);
    }
}
