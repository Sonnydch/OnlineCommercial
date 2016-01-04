package com.du.mall.service.impl;

import com.du.mall.dao.CartItemDao;
import com.du.mall.entity.CartItem;
import com.du.mall.service.CartItemService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public class CartItemServiceImpl implements CartItemService {

  private CartItemDao cartItemDao;

  public CartItemDao getCartItemDao() {
    return cartItemDao;
  }

  public void setCartItemDao(CartItemDao cartItemDao) {
    this.cartItemDao = cartItemDao;
  }

  public void addCartItem(CartItem cartItem) {
    cartItemDao.addCartItem(cartItem);
  }

  public void deleteCartItem(CartItem cartItem) {
    cartItemDao.deleteCartItem(cartItem);
  }

  public List<CartItem> findCartItemById(int id) {
    return cartItemDao.findCartItemById(id);
  }

  public List<CartItem> findCartItemByBuyer(int buyerId) {
    return cartItemDao.findCartItemByBuyer(buyerId);
  }

  public List<CartItem> findCartItemBySeller(int sellerId) {
    return cartItemDao.findCartItemBySeller(sellerId);
  }

  public List<CartItem> findCartItemByProduct(int productId) {
    return cartItemDao.findCartItemByProduct(productId);
  }

  public List<CartItem> listAll() {
    return cartItemDao.listAll();
  }
}
