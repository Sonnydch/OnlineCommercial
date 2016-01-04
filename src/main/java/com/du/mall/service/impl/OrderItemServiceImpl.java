package com.du.mall.service.impl;

import com.du.mall.dao.OrderItemDao;
import com.du.mall.entity.OrderItem;
import com.du.mall.service.OrderItemService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/27.
 */
public class OrderItemServiceImpl implements OrderItemService {
  private OrderItemDao orderItemDao;

  public OrderItemDao getOrderItemDao() {
    return orderItemDao;
  }

  public void setOrderItemDao(OrderItemDao orderItemDao) {
    this.orderItemDao = orderItemDao;
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItemDao.addOrderItem(orderItem);
  }

  public void deleteOrderItem(OrderItem orderItem) {
    orderItemDao.deleteOrderItem(orderItem);
  }

  public void updateOrderItem(OrderItem orderItem) {
    orderItemDao.updateOrderItem(orderItem);
  }

  public List<OrderItem> findOrderItemById(int id) {
    return orderItemDao.findOrderItemById(id);
  }

  public List<OrderItem> findOrderItemByBuyer(int id) {
    return orderItemDao.findOrderItemByBuyer(id);
  }

  public List<OrderItem> findOrderItemBySeller(int id) {
    return orderItemDao.findOrderItemBySeller(id);
  }

  public List<OrderItem> listAll() {
    return orderItemDao.listAll();
  }
}
