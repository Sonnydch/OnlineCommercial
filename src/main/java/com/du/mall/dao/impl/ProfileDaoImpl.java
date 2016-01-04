package com.du.mall.dao.impl;

import com.du.mall.dao.ProductDao;
import com.du.mall.dao.ProfileDao;
import com.du.mall.entity.Product;
import com.du.mall.entity.Profile;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/31.
 */
@SuppressWarnings("ALL")
public class ProfileDaoImpl extends HibernateDaoSupport implements ProfileDao{

  public void addProfile(Profile profile) {
    getHibernateTemplate().save(profile);
  }

  public void deleteProfile(Profile profile) {
    getHibernateTemplate().delete(profile);
  }

  public void updateProfile(Profile profile) {
    getHibernateTemplate().update(profile);
  }

  public List<Profile> findProfileByUser(int userId) {
    return getHibernateTemplate().find("from Profile where userId = ?", userId);
  }

  public List<Profile> findProfileById(int id) {
    return getHibernateTemplate().find("from Profile where id = ?", id);
  }

  public List<Profile> listAll() {
    return getHibernateTemplate().find("from Profile ");
  }
}
