package com.du.mall.action;

import com.du.mall.entity.Comment;
import com.du.mall.entity.User;
import com.du.mall.service.CommentService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public class CommentAction extends ActionSupport {
  private int owerId;
  private int productId;
  private Comment comment;
  private int commentId;
  private List<Comment> commentList;
  private CommentService commentService;

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  public CommentService getCommentService() {
    return commentService;
  }

  public void setCommentService(CommentService commentService) {
    this.commentService = commentService;
  }

  public CommentAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    commentService = (CommentService)ctx.getBean("commentService");
  }

  public String listAll(){
    commentList = commentService.listAll();
    return SUCCESS;
  }

  public String listMy(){
    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    commentList = commentService.findByOwnerId(user.getId());
    return SUCCESS;
  }
  public String deleteById(){
    comment = new Comment();
    comment.setId(commentId);
    commentService.deleteComment(comment);
    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    if(user.getRole().equalsIgnoreCase("admin")){
      commentList = commentService.listAll();
    }else{
      commentList = commentService.findByOwnerId(user.getId());
    }
    return SUCCESS;
  }
  public int getOwerId() {
    return owerId;
  }

  public void setOwerId(int owerId) {
    this.owerId = owerId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }
}
