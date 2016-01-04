package com.du.mall.service.impl;

import com.du.mall.dao.PictureDao;
import com.du.mall.entity.Picture;
import com.du.mall.service.PictureService;

import java.util.List;

/**
 * Created by Sonny on 2016/1/2.
 */
public class PictureServiceImpl implements PictureService {

  private PictureDao pictureDao;

  public PictureDao getPictureDao() {
    return pictureDao;
  }

  public void setPictureDao(PictureDao pictureDao) {
    this.pictureDao = pictureDao;
  }

  public void addPicture(Picture picture) {
    pictureDao.addPicture(picture);
  }

  public void deletePicture(Picture picture) {
    pictureDao.deletePicture(picture);
  }

  public List<Picture> findPicureById(int id) {
    return pictureDao.findPicureById(id);
  }

  public List<Picture> listPictureByProduct(int product) {
    return pictureDao.listPictureByProduct(product);
  }

  public List<Picture> listAll() {
    return pictureDao.listAll();
  }
}
