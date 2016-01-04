package com.du.mall.dao.impl;

import com.du.mall.dao.UserDao;
import com.du.mall.entity.User;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sonny on 2015/12/20.
 */
public class UserDaoImplTest extends TestCase {

  private ApplicationContext context = null;
  private User user = null;
  private UserDao userDAO = null;
  public void setUp() throws Exception {
    super.setUp();
    context = new ClassPathXmlApplicationContext("applicationContext.xml");
    userDAO = (UserDao)context.getBean("userDAO");
  }
  public void tearDown() throws Exception {
    userDAO = null;
    user = null;
  }
  public void testAddUser() throws Exception {
    user = new User();
    user.setName("username");
    user.setPassword("password");
    userDAO.addUser(user);
    Assert.assertNotNull(user.getId());
    User userTwo = new User();
    userTwo.setName("username1");
    userTwo.setPassword("password");
    userDAO.addUser(userTwo);
    Assert.assertNotNull(user.getId());
  }
  public void testListAll() throws Exception {
    testAddUser();//add first;
    List<User> users = userDAO.listAll();
    Assert.assertEquals(2, users.size());
  }



  public void testFindUserByName() throws Exception {
    testAddUser();
    user = userDAO.findUserByName("username").get(0);
    Assert.assertEquals(1,user.getId());

  }

  public void testUpdateUser() throws Exception {
    testAddUser();
    User userT = new User();
    userT.setId(1);
    userT.setName("update");
    userT.setEmail("lll@qq.com");
    userT.setPassword("update");
    userDAO.updateUser(userT);
    Assert.assertNotNull(userDAO.findUserByName("update"));
  }

  public void testDeleteUser() throws Exception {
    testUpdateUser();
    User userT = new User();
    userT.setId(1);
    userT.setName("update");
    userT.setEmail("lll@qq.com");
    userT.setPassword("update");
    userDAO.deleteUser(userT);
    Assert.assertNotNull(userDAO.findUserByName("update"));
  }

}