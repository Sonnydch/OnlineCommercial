package com.du.mall.dao.impl;

import com.du.mall.dao.CartItemDao;
import com.du.mall.entity.CartItem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
@SuppressWarnings("ALL")
public class CartItemDaoImpl extends HibernateDaoSupport implements CartItemDao{

  public void addCartItem(CartItem cartItem) {
    getHibernateTemplate().save(cartItem);
  }

  public void deleteCartItem(CartItem cartItem) {
    getHibernateTemplate().delete(cartItem);
  }

  public List<CartItem> findCartItemById(int id) {
    return getHibernateTemplate().find("from CartItem where id = ?",id);
  }

  public List<CartItem> findCartItemByBuyer(int buyerId) {
    return getHibernateTemplate().find("from CartItem where buyerId = ?", buyerId);
  }

  public List<CartItem> findCartItemBySeller(int sellerId) {
    return getHibernateTemplate().find("from CartItem where sellerId = ?", sellerId);
  }

  public List<CartItem> findCartItemByProduct(int productId) {
    return getHibernateTemplate().find("from CartItem where productId = ?", productId);
  }

  public List<CartItem> listAll() {
    return getHibernateTemplate().find("from CartItem ");
  }
}
