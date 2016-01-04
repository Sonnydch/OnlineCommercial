package com.du.mall.action;

import com.du.mall.entity.Profile;
import com.du.mall.entity.Result;
import com.du.mall.entity.User;
import com.du.mall.service.ProfileService;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sonny on 2015/12/21.
 */
public class UserRegisterAction extends ActionSupport {
  private UserService userService;
  private ProfileService profileService;
  private User user;
  private Map<String,Object> dataMap;

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public UserRegisterAction(){
    ApplicationContext context = InitApplicationContext.getApplicationContext();
    userService = (UserService)context.getBean("userService");
    profileService = (ProfileService)context.getBean("profileService");
  }

  public String execute(){
    dataMap = new HashMap<String, Object>();
    Result result = new Result();
    if(!isValid(user.getName())){
      result.setResult(false);
      result.setMessage("用户名不符合格式!");
      result.setExtra("");
    }else if(!isValid(user.getPassword())){
      result.setResult(false);
      result.setMessage("密码不符合格式");
      result.setExtra("");
    }else if(userCheckExist(user)){
      result.setResult(false);
      result.setMessage("用户已存在!");
      result.setExtra("");
    }else{
      result.setResult(true);
      result.setMessage("注册成功!");
      result.setExtra("");
    }
    dataMap.put("result",result);
    System.out.println("want to register");
    System.out.println(user);
    if(result.getResult()){
      userService.addUser(user);
      Profile profile = new Profile();
      user = userService.findUserByName(user.getName()).get(0);
      profile.setUserId(user.getId());
      profile.setAvatar("image.png");
      profile.setCoin(0);
      profileService.addProfile(profile);
      ActionContext.getContext().getSession().put("user",user);
      ActionContext.getContext().getSession().put("avatar","image.png");
    }
    return SUCCESS;
  }

  public Map<String, Object> getDataMap() {
    return dataMap;
  }


  public boolean userCheckExist(User user) {
    List<User> userList = userService.findUserByName(user.getName());
    if (userList == null || userList.size() < 1) {
      return false;
    }
    User checkUser = userList.get(0);
    System.out.println("user exist"+checkUser.getName());
    return true;
  }
  public boolean isValid(String keyword){
    return keyword != null && keyword !="";
  }
}
