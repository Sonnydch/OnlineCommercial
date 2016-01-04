package com.du.mall.action;

import com.du.mall.entity.Comment;
import com.du.mall.entity.Picture;
import com.du.mall.entity.Product;
import com.du.mall.entity.User;
import com.du.mall.service.CartItemService;
import com.du.mall.service.CommentService;
import com.du.mall.service.PictureService;
import com.du.mall.service.ProductService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Sonny on 2015/12/26.
 */
public class DetailAction extends ActionSupport {
  private int productId;
  private Product product;
  private ProductService productService;
  private CommentService commentService;
  private CartItemService cartItemService;
  private PictureService pictureService;
  private List<Comment> commentList;
  private List<Picture> pictureList;
  private String content;//单次评论内容

  public List<Picture> getPictureList() {
    return pictureList;
  }

  public void setPictureList(List<Picture> pictureList) {
    this.pictureList = pictureList;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public DetailAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    productService = (ProductService) ctx.getBean("productService");
    commentService = (CommentService) ctx.getBean("commentService");
    cartItemService = (CartItemService) ctx.getBean("cartItemService");
    pictureService = (PictureService) ctx.getBean("pictureService");
  }

  public CartItemService getCartItemService() {
    return cartItemService;
  }

  public void setCartItemService(CartItemService cartItemService) {
    this.cartItemService = cartItemService;
  }

  public CommentService getCommentService() {
    return commentService;
  }

  public void setCommentService(CommentService commentService) {
    this.commentService = commentService;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String execute() throws Exception {

    System.out.println("product id: "+productId);

    product = productService.findById(productId).get(0);
    commentList = commentService.findByProductId(productId);
    pictureList = pictureService.listPictureByProduct(productId);

    return SUCCESS;
  }
  public String addComment(){
    System.out.println("add content: "+content);
    System.out.println("add productId: "+productId);
    Comment comment = new Comment();
    comment.setCreateAt(new Date());
    comment.setContent(content);
    comment.setProduct(productId);
    User user = (User)ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    comment.setOwnerId(user.getId());
    comment.setOwner(user.getName());
    comment.setAvatar((String)ActionContext.getContext().getSession().get("avatar"));
    commentService.addComment(comment);
    product = productService.findById(productId).get(0);
    commentList = commentService.findByProductId(productId);
    pictureList = pictureService.listPictureByProduct(productId);
    return SUCCESS;
  }


  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
