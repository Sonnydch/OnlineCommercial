package com.du.mall.util;

import org.hibernate.dialect.MySQLInnoDBDialect;

/**
 * Created by Sonny on 2015/12/28.
 */
public class OurMysqlDialect extends MySQLInnoDBDialect {
  @Override
  public String getTableTypeString(){
    return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
  }
}
