package com.du.mall.dao.impl;

import com.du.mall.dao.CommentDao;
import com.du.mall.entity.Comment;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/28.
 */
@SuppressWarnings("ALL")
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {

  public void addComment(Comment comment) {
    getHibernateTemplate().save(comment);
  }

  public void deleteComment(Comment comment) {
    getHibernateTemplate().delete(comment);
  }

  public List<Comment> findByOwnerId(int ownerId) {
    return getHibernateTemplate().find("from Comment where ownerId = ?",ownerId);
  }

  public List<Comment> findByProductId(int product) {
    return getHibernateTemplate().find("from Comment where product = ?", product);
  }

  public List<Comment> listAll() {
    return getHibernateTemplate().find("from Comment ");
  }
}
