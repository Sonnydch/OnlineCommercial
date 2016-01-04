package com.du.mall.entity;

import java.io.Serializable;

/**
 * Created by Sonny on 2015/12/26.
 */
public class Product implements Serializable {
  private int id;
  private String name;
  private String type;
  private String description;
  private String cover;
  private float price;
  private float discount=1;
  private int owner;
  private boolean taken;

  public float getDiscount() {
    return discount;
  }

  public void setDiscount(float discount) {
    this.discount = discount;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public boolean isTaken() {
    return taken;
  }

  public void setTaken(boolean taken) {
   this.taken = taken;
  }

  public int getOwner() {
    return owner;
  }

  public void setOwner(int owner) {
    this.owner = owner;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
