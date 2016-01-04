package com.du.mall.dao.impl;

import com.du.mall.dao.PictureDao;
import com.du.mall.entity.Picture;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2016/1/2.
 */

@SuppressWarnings("ALL")
public class PictureDaoImpl extends HibernateDaoSupport implements PictureDao {
  public void addPicture(Picture picture) {
    getHibernateTemplate().save(picture);
  }

  public void deletePicture(Picture picture) {
    getHibernateTemplate().delete(picture);
  }

  public List<Picture> findPicureById(int id) {
    return getHibernateTemplate().find("from Picture where id = ?", id);
  }

  public List<Picture> listPictureByProduct(int product) {
    return getHibernateTemplate().find("from Picture where productId = ?", product);
  }

  public List<Picture> listAll() {
    return getHibernateTemplate().find("from Picture ");
  }
}
