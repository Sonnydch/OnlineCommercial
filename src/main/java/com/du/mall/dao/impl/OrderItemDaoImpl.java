package com.du.mall.dao.impl;

import com.du.mall.dao.OrderItemDao;
import com.du.mall.entity.OrderItem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/27.
 */

@SuppressWarnings("ALL")
public class OrderItemDaoImpl extends HibernateDaoSupport implements OrderItemDao {
  public void addOrderItem(OrderItem orderItem) {
    getHibernateTemplate().save(orderItem);
  }

  public void deleteOrderItem(OrderItem orderItem) {
    getHibernateTemplate().delete(orderItem);
  }

  public void updateOrderItem(OrderItem orderItem) {
    getHibernateTemplate().update(orderItem);
  }

  public List<OrderItem> findOrderItemById(int id) {
    return getHibernateTemplate().find("from OrderItem where id = ?",id);
  }

  public List<OrderItem> findOrderItemByBuyer(int id) {
    return getHibernateTemplate().find("from OrderItem where buyer = ?",id);
  }

  public List<OrderItem> findOrderItemBySeller(int id) {
    return getHibernateTemplate().find("from OrderItem where seller = ?",id);
  }

  public List<OrderItem> listAll() {
    return getHibernateTemplate().find("from OrderItem");
  }
}
