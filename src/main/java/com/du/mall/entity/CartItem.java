package com.du.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sonny on 2015/12/28.
 */
public class CartItem implements Serializable {
  private int id;
  private int productId;
  private String productName;
  private int buyerId;
  private String buyer;
  private int sellerId;
  private Date createAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(int buyerId) {
    this.buyerId = buyerId;
  }

  public String getBuyer() {
    return buyer;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public int getSellerId() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }
}
