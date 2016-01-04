package com.du.mall.action;

import com.du.mall.dao.UserDao;
import com.du.mall.dao.impl.UserDaoImplTest;
import com.du.mall.entity.User;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.Action;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

/**
 * Created by Sonny on 2015/12/20.
 */
public class UserLoginActionTest extends TestCase {
  private User user;
  private UserDao userDao;
  private UserService userService;
  private ApplicationContext context = null;
  private UserLoginAction loginAction = null;

  public void setUp(){
    context = InitApplicationContext.getApplicationContext();
    userDao= (UserDao)context.getBean("userDAO");
    loginAction = new UserLoginAction();
    userService = (UserService)context.getBean("userService");
  }
  public void testUserLogin(){
    user = new User();
    user.setName("username");
    user.setPassword("password");
    userDao.addUser(user);
    //需要先执行UserDaoTest测试
    user = new User();
    user.setName("username");
    user.setPassword("password");
    try {
      loginAction.setUser(user);
      loginAction.setUserService(userService);
      Assert.assertEquals(Action.SUCCESS, loginAction.execute());
      user.setPassword("password1");
      System.out.println(loginAction.getActionErrors());
      Assert.assertEquals(Action.INPUT, loginAction.execute());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}