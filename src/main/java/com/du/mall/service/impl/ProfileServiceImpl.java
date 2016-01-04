package com.du.mall.service.impl;

import com.du.mall.dao.ProfileDao;
import com.du.mall.entity.Profile;
import com.du.mall.service.ProfileService;

import java.util.List;

/**
 * Created by Sonny on 2015/12/31.
 */
public class ProfileServiceImpl implements ProfileService{

  private ProfileDao profileDao;

  public ProfileDao getProfileDao() {
    return profileDao;
  }

  public void setProfileDao(ProfileDao profileDao) {
    this.profileDao = profileDao;
  }

  public void addProfile(Profile profile) {
    profileDao.addProfile(profile);
  }

  public void deleteProfile(Profile profile) {
    profileDao.deleteProfile(profile);
  }

  public void updateProfile(Profile profile) {
    profileDao.updateProfile(profile);
  }

  public List<Profile> findProfileByUser(int userId) {
    return profileDao.findProfileByUser(userId);
  }

  public List<Profile> findProfileById(int id) {
    return profileDao.findProfileById(id);
  }

  public List<Profile> listAll() {
    return profileDao.listAll();
  }
}
