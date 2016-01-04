package com.du.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sonny on 2015/12/28.
 */
public class Comment implements Serializable{
  private int id;
  private int product;
  private String content;
  private Date createAt;
  private String owner;
  private int ownerId;
  private String avatar;

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public int getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(int ownerId) {
    this.ownerId = ownerId;
  }
}
