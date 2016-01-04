package com.du.mall.dao.impl;

import com.du.mall.dao.UserDao;
import com.du.mall.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Sonny on 2015/12/20.
 */
@SuppressWarnings("ALL")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

  public String addUser(User user) {
    String message = "";
    String name = user.getName();
    if(findUserByName(name).size() == 0){
      try{
        getHibernateTemplate().save(user);
        message = "User saved ok!";

      }catch(DataAccessException e){
        message ="sorry ,user added failed";
      }
    }else{
      message = "username existed already!";
    }
    return message;
  }

  public List<User> findUserByName(String name) {
    return getHibernateTemplate().find("from User where name = ?", name);
  }

  public List<User> findUserById(int id) {
    return getHibernateTemplate().find("from User where id = ?",id);
  }

  public void updateUser(User user) {
     getHibernateTemplate().update(user);
  }

  public void deleteUser(User user) {
     getHibernateTemplate().delete(user);
  }

  public List<User> listAll() {
    return getHibernateTemplate().find("from User ");
  }
}
