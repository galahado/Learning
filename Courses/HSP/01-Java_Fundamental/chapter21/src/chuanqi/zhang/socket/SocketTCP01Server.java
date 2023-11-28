package chuanqi.zhang.socket;

import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]

        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续

        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        //4. IO读取

        //5.关闭流和socket

    }
}
