package com.myapp.DAOinterface;

import com.myapp.model.Brand;

import java.util.List;

public interface BrandDAOI {
    enum SQL {
        UPDATE_BRAND_BY_ID("UPDATE brand SET name=:name, description:=description WHERE id = ?"),
        GET_BRAND_BY_ID("SELECT * FROM brand WHERE id = ?"),
        GET_BRAND_BY_NAME("SELECT * FROM brand WHERE name = ?"),
        GET_ALL_BRANDS("SELECT * FROM brand"),
        DELETE_BRAND_BY_ID("DELETE FROM brand WHERE id = ?");

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }

    public Brand saveBrand(Brand brand);

    public Brand getBrandById(int id);

    public boolean deleteBrandById(int id);

    List<Brand> getBrandByName(String name);

    public List<Brand> getAllBrands();
}
