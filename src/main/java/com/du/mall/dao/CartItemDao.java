package com.du.mall.dao;

import com.du.mall.entity.CartItem;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public interface CartItemDao {
  public void addCartItem(CartItem cartItem);
  public void deleteCartItem(CartItem cartItem);
  public List<CartItem> findCartItemById(int id);
  public List<CartItem> findCartItemByBuyer(int buyerId);
  public List<CartItem> findCartItemBySeller(int sellerId);
  public List<CartItem> findCartItemByProduct(int productId);
  public List<CartItem> listAll();
}
