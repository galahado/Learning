package chuanqi.zhang.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @author 韩顺平
 * @version 1.0
 * 文件上传的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //客户端连接服务端 8888，得到Socket对象

        //创建读取磁盘文件的输入流
        //String filePath = "e:\\qie.png";

        //bytes 就是filePath对应的字节数组

        //通过socket获取到输出流, 将bytes数据发送给服务端

        //=====接收从服务端回复的消息=====

        //使用StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串

        //关闭相关的流

    }


}
