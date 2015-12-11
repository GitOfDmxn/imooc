package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class Server {

  public static void main(String[] args) {
    //1、创建服务器的Socket即ServerSocet，指定绑定的端口，并监听此端口
    try {
      ServerSocket serverSocket = new ServerSocket(9999);
      //2、调用accept()方法开始监听，等待客户端连接
      System.out.println("***服务器即将启动，等待客户端连接***");
      //一旦调用aacet方法，当前线程处于阻塞状态，等待客户端连接
      Socket socket = serverSocket.accept();//accept返回socket实例用来与客户端通信
      //3、获取输入流，并读取客户端信息
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);//提高讲取速度
      String info = null;
      while((info=br.readLine())!= null){
        System.out.println("我是服务器，客户端说："+info);
      }    
      socket.shutdownInput();//关闭输入流
      //4、获取输出流，响应客户端请求
      System.out.println();
      OutputStream os = socket.getOutputStream();
      PrintWriter pw = new PrintWriter(os);
      pw.write("欢迎您！");
      pw.flush();
      //5、关闭相关资源
      pw.close();
      os.close();
      br.close();
      isr.close();
      is.close();
      socket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
