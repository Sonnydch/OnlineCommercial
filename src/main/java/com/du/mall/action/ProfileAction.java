package com.du.mall.action;

import com.du.mall.entity.Profile;
import com.du.mall.entity.User;
import com.du.mall.service.ProductService;
import com.du.mall.service.ProfileService;
import com.du.mall.service.UserService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sonny on 2015/12/31.
 */
public class ProfileAction extends ActionSupport implements ServletRequestAware {
  private int profileId;
  private Profile profile;
  private ProfileService profileService;
  private UserService userService;
  private List<Profile> profileList;
  private File myFile;
  private String myFileContentType;
  private String myFileFileName;
  private String destPath;
  private String myAvatar;

  private HttpServletRequest servletRequest;
  public File getMyFile() {
    return myFile;
  }

  public void setMyFile(File myFile) {
    this.myFile = myFile;
  }

  public String getMyFileContentType() {
    return myFileContentType;
  }

  public void setMyFileContentType(String myFileContentType) {
    this.myFileContentType = myFileContentType;
  }

  public String getMyFileFileName() {
    return myFileFileName;
  }

  public void setMyFileFileName(String myFileFileName) {
    this.myFileFileName = myFileFileName;
  }

  public String getDestPath() {
    return destPath;
  }

  public void setDestPath(String destPath) {
    this.destPath = destPath;
  }

  public ProfileAction(){
    ApplicationContext ctx = InitApplicationContext.getApplicationContext();
    profileService = (ProfileService)ctx.getBean("profileService");
    userService = (UserService)ctx.getBean("userService");
  }


  public List<Profile> getProfileList() {
    return profileList;
  }

  public void setProfileList(List<Profile> profileList) {
    this.profileList = profileList;
  }

  public String myProfile(){
    User user  = (User)ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    if(profileService.findProfileByUser(user.getId()).size() < 1){
      profile = new Profile();
    }else{
      profile = profileService.findProfileByUser(user.getId()).get(0);
    }
    return SUCCESS;
  }

  public String editProfile(){
    User user  = (User)ActionContext.getContext().getSession().get("user");
    if(user==null){
      return "error";
    }
    System.out.println("profile id: "+profile.getId());
    profile.setUserId(user.getId());
    if(profile.getId() == 0){// new add
      profileService.addProfile(profile);
    }else{
      profileService.updateProfile(profile);
    }

    if(myFile != null){
      if (saveAvatar(user)) return ERROR;
      profile.setAvatar(myAvatar);
      profileService.updateProfile(profile);
      ActionContext.getContext().getSession().put("avatar",myAvatar);
    }
    profile = profileService.findProfileByUser(user.getId()).get(0);
    return SUCCESS;
  }

  private boolean saveAvatar(User user) {
    HttpSession session = servletRequest.getSession();
    ServletContext context = session.getServletContext();
    String filePath = context.getRealPath("/")+"avatars\\";
    System.out.println("Server path:" + filePath);
    try{
      System.out.println("Src File name: " + myFile);
      System.out.println("Dst File name: " + myFileFileName.split("\\.")[1]);
      String end = myFileFileName.split("\\.")[1];
      File destFile  = new File(filePath, user.getName()+"."+end);
      FileUtils.copyFile(myFile, destFile);
      myAvatar = user.getName()+"."+end;
    }catch(IOException e){
      e.printStackTrace();
      return true;
    }
    return false;
  }

  public String listAll(){

    profileList = profileService.listAll();

    return "listAll";
  }

  public String delete(){

    profile = profileService.findProfileById(profileId).get(0);
    User user = userService.findUserById(profile.getUserId()).get(0);
    profileService.deleteProfile(profile);
    userService.deleteUser(user);
    profileList = profileService.listAll();
    return "listAll";

  }
  public int getProfileId() {
    return profileId;
  }

  public void setProfileId(int profileId) {
    this.profileId = profileId;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public ProfileService getProfileService() {
    return profileService;
  }

  public void setProfileService(ProfileService profileService) {
    this.profileService = profileService;
  }

  public void setServletRequest(HttpServletRequest httpServletRequest) {
    this.servletRequest = httpServletRequest;
  }
}
