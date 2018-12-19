package com.neuedu.service;

import com.neuedu.dao.IProductDao;
import com.neuedu.dao.ProductDaoImpl;
import com.neuedu.pojo.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public int delt(int id) {
        return productDao.dele(id);
    }

    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public Product getOne(int productId) {
        return productDao.getOne(productId);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public List<Product> getFuzzyQuery(String key) {
        return productDao.getFuzzyQuery(key);
    }
}
