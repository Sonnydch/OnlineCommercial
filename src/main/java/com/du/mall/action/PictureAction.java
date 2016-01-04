package com.du.mall.action;

import com.du.mall.entity.Picture;
import com.du.mall.entity.Product;
import com.du.mall.service.PictureService;
import com.du.mall.service.ProductService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Sonny on 2016/1/2.
 */
public class PictureAction extends ActionSupport {
  private Picture picture;
  private int pictureId;
  private PictureService pictureService;
  private Product product;
  private int productId;
  private List<Picture> pictureList;
  private ProductService productService;
  public PictureAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    pictureService =(PictureService)ctx.getBean("pictureService");
    productService = (ProductService) ctx.getBean("productService");
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public Picture getPicture() {
    return picture;
  }

  public void setPicture(Picture picture) {
    this.picture = picture;
  }

  public int getPictureId() {
    return pictureId;
  }

  public void setPictureId(int pictureId) {
    this.pictureId = pictureId;
  }

  public PictureService getPictureService() {
    return pictureService;
  }

  public void setPictureService(PictureService pictureService) {
    this.pictureService = pictureService;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public List<Picture> getPictureList() {
    return pictureList;
  }

  public void setPictureList(List<Picture> pictureList) {
    this.pictureList = pictureList;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  public String delete(){
    System.out.println("delete"+pictureId);
    picture = new Picture();
    picture.setId(pictureId);
    pictureService.deletePicture(picture);
    product = productService.findById(productId).get(0);
    pictureList = pictureService.listPictureByProduct(productId);
    return SUCCESS;
  }
}
