package com.du.mall.entity;

import java.util.Date;

/**
 * Created by Sonny on 2015/12/27.
 */
public class OrderItem {
  private int id;
  private int product;
  private int buyer;
  private int seller;
  private String status;
  private Date createAt;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProduct() {
    return product;
  }

  public void setProduct(int product) {
    this.product = product;
  }

  public int getBuyer() {
    return buyer;
  }

  public void setBuyer(int buyer) {
    this.buyer = buyer;
  }

  public int getSeller() {
    return seller;
  }

  public void setSeller(int seller) {
    this.seller = seller;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }
}
