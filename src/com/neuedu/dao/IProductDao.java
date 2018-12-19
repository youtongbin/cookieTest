package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getProducts();
    int dele(int id);
    int insert(Product product);
    Product getOne(int productId);
    int update(Product product);
    List<Product> getFuzzyQuery(String key);
}
