package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 */
public class Test01 {

  /**
   * @param args
   * @throws UnknownHostException
   */
  public static void main(String[] args) throws UnknownHostException {
    //获取本机的InetAddress实例
    InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名："+address.getHostName());
        System.out.println("IP地址："+address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP："+Arrays.toString(bytes));
        System.out.println(address);
        //根据主机名获取 InetAddress实例
        InetAddress  address2 = InetAddress.getByName("seA-pc");
        System.out.println("计算机名："+address2.getHostName());
        System.out.println("IP地址："+address2.getHostAddress());
        InetAddress  address3 = InetAddress.getByName("192.168.1.202");
        System.out.println("计算机名："+address3.getHostName());
        System.out.println("IP地址："+address3.getHostAddress());
  }

}
