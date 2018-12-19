package com.neuedu.dao;

import com.neuedu.pojo.Product;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> getProducts() {
        return JdbcUtil.executeQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null);
    }

    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from product where product_id = ?",id);
    }

    @Override
    public int insert(Product product) {
        return JdbcUtil.executeUpdate("insert into product(product_name,price,url) values(?,?,?)",product.getProductName(),product.getPrice(),product.getUrl());
    }

    @Override
    public Product getOne(int productId) {
        return JdbcUtil.getOne("select * from product where product_id = ?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, productId);
    }

    @Override
    public int update(Product product) {
        return JdbcUtil.executeUpdate("update product set product_name = ?,price = ?,url = ? where product_id = ? ",product.getProductName(),product.getPrice(),product.getUrl(),product.getProductId());
    }

    @Override
    public List<Product> getFuzzyQuery(String key) {
        return JdbcUtil.executeQuery("select * from product where product_name like concat('%',?,'%')", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, key);
    }
}
