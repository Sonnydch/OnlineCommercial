package com.du.mall.action;

import com.du.mall.entity.CartItem;
import com.du.mall.entity.Product;
import com.du.mall.entity.User;
import com.du.mall.service.CartItemService;
import com.du.mall.service.ProductService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public class CartAction extends ActionSupport {
  private CartItem cartItem;
  private List<CartItem> cartItemList;
  private int cartItemId;
  private int productId;
  private CartItemService cartItemService;
  private ProductService productService;
  public CartAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    cartItemService = (CartItemService)ctx.getBean("cartItemService");
    productService = (ProductService)ctx.getBean("productService");
  }

  public CartItem getCartItem() {
    return cartItem;
  }

  public void setCartItem(CartItem cartItem) {
    this.cartItem = cartItem;
  }

  public List<CartItem> getCartItemList() {
    return cartItemList;
  }

  public void setCartItemList(List<CartItem> cartItemList) {
    this.cartItemList = cartItemList;
  }

  public int getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(int cartItemId) {
    this.cartItemId = cartItemId;
  }

  public CartItemService getCartItemService() {
    return cartItemService;
  }

  public void setCartItemService(CartItemService cartItemService) {
    this.cartItemService = cartItemService;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String addCartItem(){

    System.out.println("product Id: "+ productId);

    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    Product product = productService.findById(productId).get(0);
    cartItem = new CartItem();
    cartItem.setCreateAt(new Date());
    cartItem.setProductId(productId);
    cartItem.setProductName(product.getName());
    cartItem.setBuyerId(user.getId());
    cartItem.setBuyer(user.getName());
    cartItem.setSellerId(product.getOwner());

    cartItemService.addCartItem(cartItem);

    cartItemList = cartItemService.findCartItemByBuyer(user.getId());

    return SUCCESS;

  }

  public String deleteCartItem(){

    System.out.println("cartItem Id: "+ cartItemId);

    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    cartItem = new CartItem();
    cartItem.setId(cartItemId);

    cartItemService.deleteCartItem(cartItem);

    cartItemList = cartItemService.findCartItemByBuyer(user.getId());

    return SUCCESS;
  }

  public String listMyCart(){
    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    cartItemList = cartItemService.findCartItemByBuyer(user.getId());
    return SUCCESS;
  }
}
