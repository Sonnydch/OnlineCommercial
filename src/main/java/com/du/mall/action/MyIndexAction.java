package com.du.mall.action;

import com.du.mall.entity.Product;
import com.du.mall.entity.Profile;
import com.du.mall.entity.User;
import com.du.mall.service.ProductService;
import com.du.mall.service.ProfileService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Sonny on 2015/12/27.
 */
public class MyIndexAction extends ActionSupport {
  private List<Product> productList;
  private ProductService productService;

  public MyIndexAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    productService = (ProductService) ctx.getBean("productService");
  }

  @Override
  public String execute() throws Exception {

    productList = productService.findAll();
    User user  = (User) ActionContext.getContext().getSession().get("user");
    return SUCCESS;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }
}
