package com.du.mall.dao;

import com.du.mall.entity.Profile;

import java.util.List;

/**
 * Created by Sonny on 2015/12/31.
 */
public interface ProfileDao {
  public void addProfile(Profile profile);
  public void deleteProfile(Profile profile);
  public void updateProfile(Profile profile);
  public List<Profile> findProfileByUser(int userId);
  public List<Profile> findProfileById(int id);
  public List<Profile> listAll();
}
