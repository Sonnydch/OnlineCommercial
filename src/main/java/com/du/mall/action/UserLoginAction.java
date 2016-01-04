package com.du.mall.action;

import com.du.mall.entity.Profile;
import com.du.mall.entity.Result;
import com.du.mall.entity.User;
import com.du.mall.service.ProfileService;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sonny on 2015/12/20.
 */
public class UserLoginAction extends ActionSupport {
  private UserService userService;
  private ProfileService profileService;
  private User user;
  private Map<String,Object> map;
  private Result result;
  private User userT;

  public UserLoginAction(){
    ApplicationContext context = InitApplicationContext.getApplicationContext();
    userService =(UserService)context.getBean("userService");
    profileService = (ProfileService)context.getBean("profileService");
  }

  @Override
  public String execute() throws Exception {
    System.out.println(user.getName());
    map = new HashMap<String,Object>();
    result = new Result();
    if(!userExist(user)){
      result.setResult(false);
      result.setMessage("该用户不存在,请注册！");
      result.setExtra("");
    }else if(!checkPwd(user)){
      result.setResult(false);
      result.setMessage("密码错误!");
      result.setExtra("");
    }else{
      result.setResult(true);
      result.setMessage("登录成功!");
      result.setExtra("");
    }

    if(result.getResult()){
      ActionContext.getContext().getSession().put("user",userT);
      Profile profile = profileService.findProfileByUser(userT.getId()).get(0);
      String myAvatar = profile.getAvatar();
      ActionContext.getContext().getSession().put("avatar",myAvatar);
    }
    map.put("result",result);
    return SUCCESS;
  }

  public String checkOut(){
    map = new HashMap<String,Object>();
    ActionContext.getContext().getSession().remove("user");
    result = new Result();
    result.setMessage("登出成功");
    result.setResult(true);
    result.setExtra("");
    map.put("result",result);
    return SUCCESS;

  }
  private boolean checkPwd(User user){
    if(user.getPassword().equalsIgnoreCase(userT.getPassword())){
      return true;
    }
    return false;
  }

  private boolean userExist(User user){

    List<User> userList = userService.findUserByName(user.getName());
    if(userList == null || userList.size()<1){
      return false;
    }
    userT = userList.get(0);

    return true;
  }

  public Map<String, Object> getMap() {
    return map;
  }

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
}
