package com.du.mall.util;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sonny on 2015/12/20.
 */
public class InitApplicationContext {

  private static ApplicationContext context =null;

  private InitApplicationContext(){

  }

  public static  ApplicationContext getApplicationContext(){
    if(context == null){
      context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    return context;
  }
}
