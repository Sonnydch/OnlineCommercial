package com.du.mall.dao;

import com.du.mall.entity.User;

import java.util.List;

/**
 * Created by Sonny on 2015/12/20.
 */
public interface UserDao {

  public String addUser(User user);
  public List<User> findUserByName(String name);
  public List<User> findUserById(int id);
  public void updateUser(User user);
  public void deleteUser(User user);
  public List<User> listAll();
}
