package chuanqi.zhang.socket;

import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 客户端，发送 "hello, server" 给服务端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象

        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象

        //3. 通过输出流，写入数据到 数据通道

        //4. 关闭流对象和socket, 必须关闭

    }
}
