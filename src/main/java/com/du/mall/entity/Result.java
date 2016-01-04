package com.du.mall.entity;

import java.io.Serializable;

/**
 * Created by Sonny on 2015/12/25.
 */
public class Result implements Serializable{
  private String message;
  private boolean result;
  private String extra;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean getResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getExtra() {
    return extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }
}
