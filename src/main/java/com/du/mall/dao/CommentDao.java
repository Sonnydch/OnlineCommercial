package com.du.mall.dao;

import com.du.mall.entity.Comment;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public interface CommentDao {
  public void addComment(Comment comment);
  public void deleteComment(Comment comment);
  public List<Comment> findByOwnerId(int ownerId);
  public List<Comment> findByProductId(int product);
  public List<Comment> listAll();
}
