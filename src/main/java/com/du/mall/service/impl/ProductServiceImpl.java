package com.du.mall.service.impl;

import com.du.mall.dao.ProductDao;
import com.du.mall.entity.Product;
import com.du.mall.service.ProductService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/26.
 */
public class ProductServiceImpl implements ProductService {
  private ProductDao productDao;

  public ProductDao getProductDao() {
    return productDao;
  }

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  public void addProduct(Product product) {
    System.out.println("temp to add"+product.getName());
    productDao.addProduct(product);
  }

  public void deletePoduct(Product product) {
    productDao.deletePoduct(product);
  }

  public void updatePoduct(Product product) {
    productDao.updatePoduct(product);

  }

  public List<Product> findAll() {
    return productDao.findAll();
  }

  public List<Product> findByType(String type) {
    return productDao.findByType(type);
  }

  public List<Product> findById(int id) {
    return productDao.findById(id);
  }

  public List<Product> findByName(String name) {
    return productDao.findByName(name);
  }

  public List<Product> findByOwner(int owner) {
    return productDao.findByOwner(owner);
  }

  public List<Product> findByText(String text) {
    return productDao.findByText(text);
  }
}
