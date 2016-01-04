package com.du.mall.service.impl;

import com.du.mall.entity.User;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Sonny on 2015/12/21.
 */
public class UserServiceImplTest extends TestCase {
  private User user;
  private UserService userService;
  private ApplicationContext context = null;
  public void setUp(){
    context = InitApplicationContext.getApplicationContext();
    userService = (UserService)context.getBean("userService");
  }

  public void testUpdateUser() throws Exception {
    testAddUser();
    user = new User();
    user.setId(userService.listAll().get(0).getId());
    userService.updateUser(user);

  }

  public void testDeleteUser() throws Exception {
    testAddUser();
    user = new User();
    user.setId(1);
    userService.deleteUser(user);
  }

  public void testAddUser() throws Exception {
    user = new User();
    user.setName("dddd");
    user.setEmail("111@222.com");
    user.setPassword("dsd");
    userService.addUser(user);
  }

  public void testFindUserByName() throws Exception {
    testAddUser();
    System.out.println(userService.findUserByName("dddd").get(0).getEmail());

  }

  public void testListAll() throws Exception {
    testAddUser();
    List<User> users  = userService.listAll();
    for(int i=0;i<users.size();i++){
      System.out.println(users.get(i).getName());
    }

  }
}