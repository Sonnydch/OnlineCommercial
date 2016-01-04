package com.du.mall.service.impl;

import com.du.mall.dao.UserDao;
import com.du.mall.entity.User;
import com.du.mall.service.UserService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/20.
 */
public class UserServiceImpl implements UserService{
  private UserDao userDao;

  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  public void deleteUser(User user) {
    userDao.deleteUser(user);
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public String addUser(User user) {
    return userDao.addUser(user);
  }

  public List<User> findUserByName(String name) {
    return userDao.findUserByName(name);
  }

  public List<User> findUserById(int id) {
    return userDao.findUserById(id);
  }

  public List<User> listAll() {
    return userDao.listAll();
  }
}
