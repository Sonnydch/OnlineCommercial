package com.du.mall.service.impl;

import com.du.mall.dao.CommentDao;
import com.du.mall.entity.Comment;
import com.du.mall.service.CommentService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
public class CommentServiceImpl implements CommentService {

  private CommentDao commentDao;

  public CommentDao getCommentDao() {
    return commentDao;
  }

  public void setCommentDao(CommentDao commentDao) {
    this.commentDao = commentDao;
  }

  public void addComment(Comment comment) {
    commentDao.addComment(comment);

  }

  public void deleteComment(Comment comment) {
    commentDao.deleteComment(comment);
  }

  public List<Comment> findByOwnerId(int ownerId) {
    return commentDao.findByOwnerId(ownerId);
  }

  public List<Comment> findByProductId(int product) {
    return commentDao.findByProductId(product);
  }

  public List<Comment> listAll() {
    return commentDao.listAll();
  }
}
