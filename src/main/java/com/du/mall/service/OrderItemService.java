package com.du.mall.service;

import com.du.mall.entity.OrderItem;

import java.util.List;

/**
 * Created by Sonny on 2015/12/27.
 */
public interface OrderItemService {
  public void addOrderItem(OrderItem orderItem);
  public void deleteOrderItem(OrderItem orderItem);
  public void updateOrderItem(OrderItem orderItem);
  public List<OrderItem> findOrderItemById(int id);
  public List<OrderItem> findOrderItemByBuyer(int id);
  public List<OrderItem> findOrderItemBySeller(int id);
  public List<OrderItem> listAll();
}
