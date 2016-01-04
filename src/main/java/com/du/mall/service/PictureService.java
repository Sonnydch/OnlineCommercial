package com.du.mall.service;

import com.du.mall.entity.Picture;

import java.util.List;

/**
 * Created by Sonny on 2016/1/2.
 */
public interface PictureService {

  public void addPicture(Picture picture);
  public void deletePicture(Picture picture);
  public List<Picture> findPicureById(int id);
  public List<Picture> listPictureByProduct(int product);
  public List<Picture> listAll();
}
