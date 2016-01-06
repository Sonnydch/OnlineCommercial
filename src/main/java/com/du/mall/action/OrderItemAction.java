package com.du.mall.action;

import com.du.mall.entity.*;
import com.du.mall.service.OrderItemService;
import com.du.mall.service.ProductService;
import com.du.mall.service.ProfileService;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sonny on 2015/12/27.
 */
public class OrderItemAction extends ActionSupport {

  private OrderItem orderItem;
  private OrderItemService orderItemService;
  private List<OrderItem> orderItemList;
  private List<OrderItemDetail> orderItemDetailList;
  private int orderItemId;
  private int buyer;
  private int seller;
  private int productId;
  private Product product;
  private ProductService productService;
  private ProfileService profileService;
  private UserService userService;

  private String status;

  private float amount;

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<OrderItemDetail> getOrderItemDetailList() {
    return orderItemDetailList;
  }

  public void setOrderItemDetailList(List<OrderItemDetail> orderItemDetailList) {
    this.orderItemDetailList = orderItemDetailList;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public OrderItemAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    orderItemService = (OrderItemService) ctx.getBean("orderItemService");
    productService = (ProductService) ctx.getBean("productService");
    profileService = (ProfileService) ctx.getBean("profileService");
    userService = (UserService) ctx.getBean("userService");
  }

  public String addOrderItem(){

    User user = (User)ActionContext.getContext().getSession().get("user");
    buyer = user.getId();
    product = productService.findById(productId).get(0);

    if(product.isTaken()){
      System.out.println("already taken!");
      return "error";
    }
    seller = product.getOwner();

    orderItem = new OrderItem();
    orderItem.setBuyer(buyer);
    orderItem.setCreateAt(new Date());
    orderItem.setProduct(productId);
    orderItem.setSeller(seller);
    orderItem.setStatus("pay");//buy pay ship finish fail;
    product.setTaken(true);
    productService.updatePoduct(product);
    orderItemService.addOrderItem(orderItem);
    orderItemList = orderItemService.findOrderItemByBuyer(user.getId());
    toDetailList();
    return "listBuyer";
  }

  public String addToPay(){
    User user = (User)ActionContext.getContext().getSession().get("user");
    buyer = user.getId();
    product = productService.findById(productId).get(0);
    amount = product.getPrice();
    return "listAccount";
  }

  private void toDetailList() {
    orderItemDetailList = new ArrayList<OrderItemDetail>();
    OrderItemDetail orderItemDetail;
    for(OrderItem item : orderItemList){
      orderItemDetail =  new OrderItemDetail();
      orderItemDetail.setBuyer(userService.findUserById(item.getBuyer()).get(0).getName());
      orderItemDetail.setId(item.getId());
      orderItemDetail.setSeller(userService.findUserById(item.getSeller()).get(0).getName());
      orderItemDetail.setProduct(productService.findById(item.getProduct()).get(0).getName());
      orderItemDetail.setCreateAt(item.getCreateAt());
      orderItemDetail.setStatus(item.getStatus());
      orderItemDetailList.add(orderItemDetail);
    }
  }

  public String listAllBuyer(){
    User user = (User)ActionContext.getContext().getSession().get("user");
    orderItemList = orderItemService.findOrderItemByBuyer(user.getId());
    toDetailList();
    return "listBuyer";
  }

  public String listAllSeller(){
    User user = (User)ActionContext.getContext().getSession().get("user");
    orderItemList = orderItemService.findOrderItemBySeller(user.getId());
    toDetailList();;
    return "listSeller";
  }

  public String changeStatus(){
    User user = (User)ActionContext.getContext().getSession().get("user");
    System.out.println(status);
    orderItem = orderItemService.findOrderItemById(orderItemId).get(0);
    orderItem.setStatus(status);
    if(status.equalsIgnoreCase("finish")){
      Profile profile = profileService.findProfileByUser(user.getId()).get(0);
      profile.setCoin(profile.getCoin()+1);//积分加一
      profileService.updateProfile(profile);
    }
    orderItemService.updateOrderItem(orderItem);
    orderItemList = orderItemService.findOrderItemBySeller(user.getId());
    toDetailList();
    return "listSeller";
  }

  public String listAllSuper(){
    orderItemList = orderItemService.listAll();
    toDetailList();
    return "listBuyer";
  }
  public OrderItem getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(OrderItem orderItem) {
    this.orderItem = orderItem;
  }

  public OrderItemService getOrderItemService() {
    return orderItemService;
  }

  public void setOrderItemService(OrderItemService orderItemService) {
    this.orderItemService = orderItemService;
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }

  public int getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(int orderItemId) {
    this.orderItemId = orderItemId;
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
}
