package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL常用方法
 */
public class Test02 {

  public static void main(String[] args) {
    //创建一个URL实例
    try {
      URL imooc = new URL("http://www.imooc.com");
      URL url = new URL(imooc, "/index.html?username=tom#test");//?后面表示参数，#后面表示锚点
      System.out.println("协议："+url.getProtocol());
      System.out.println("主机："+url.getHost());
      // 如果未指定协议，则使用默认端口，此时getPort方法返回值是-1
      System.out.println("端口号："+url.getPort());
      System.out.println("文件路径："+url.getPath());
      System.out.println("文件名称："+url.getFile());
      System.out.println("相关路径："+url.getRef());
      System.out.println("查询字符串"+url.getQuery());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
