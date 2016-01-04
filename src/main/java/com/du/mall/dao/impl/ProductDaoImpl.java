package com.du.mall.dao.impl;

import com.du.mall.dao.ProductDao;
import com.du.mall.entity.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/26.
 */
@SuppressWarnings("ALL")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {


  public void addProduct(Product product) {
    try{
      getHibernateTemplate().save(product);

    }catch(DataAccessException e){
      e.printStackTrace();
    }
  }

  public void deletePoduct(Product product) {
      getHibernateTemplate().delete(product);
  }

  public void updatePoduct(Product product) {
    getHibernateTemplate().update(product);

  }

  public List<Product> findAll() {
    return getHibernateTemplate().find("from Product ");
  }

  public List<Product> findByType(String type) {
    return getHibernateTemplate().find("from Product where type = ?", type);
  }

  public List<Product> findById(int id) {
    return getHibernateTemplate().find("from Product where id = ?", id);
  }

  public List<Product> findByName(String name) {
    return getHibernateTemplate().find("from Product where name = ?", name);
  }

  public List<Product> findByOwner(int owner) {
    return getHibernateTemplate().find("from Product where owner = ?", owner);
  }

  public List<Product> findByText(String text) {
    return getHibernateTemplate().find("from Product where name LIKE ?","%"+text+"%");
  }
}
