package com.neuedu.service;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    int delt(int id);
    int insert(Product product);
    Product getOne(int productId);
    int update(Product product);
    List<Product> getFuzzyQuery(String key);
}
