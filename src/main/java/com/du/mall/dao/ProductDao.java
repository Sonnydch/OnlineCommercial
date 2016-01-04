package com.du.mall.dao;

import com.du.mall.entity.Product;

import java.util.List;

/**
 * Created by Sonny on 2015/12/26.
 */
public interface ProductDao {
  public void addProduct(Product product);
  public void deletePoduct(Product product);
  public void updatePoduct(Product product);
  public List<Product> findAll();
  public List<Product> findByType(String type);
  public List<Product> findById(int id);
  public List<Product> findByName(String name);
  public List<Product> findByOwner(int owner);
  public List<Product> findByText(String text);

}
