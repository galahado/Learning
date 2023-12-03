import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 韩顺平
 * @version 1.0
 * 这是我们自己写的一个web服务, 可以返回hello.html给浏览器
 */
public class MyTomcat {
    public static void main(String[] args) throws IOException {

        //1.在9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);

        //如果serverSocket 没有关闭，就等待连接, 不停的等待
        while (!serverSocket.isClosed()) {
            System.out.println("=====我的web服务在 9999端口监听=====");
            //2. 等待浏览器/客户端连接, 得到socket
            //   该socket用于通信
            Socket socket = serverSocket.accept();

            //3. 通过socket 得到 输出流，[]
            OutputStream outputStream = socket.getOutputStream();
            //   返回给浏览器/客户端
            //4. 读取 hello.html 文件返回即可=> 如何读取文件内容
            //   得到文件输入流(字符输入流), 和 src/hello.html
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("src/hello.html"));
            String buf = "";
            //   循环读取hello.html
            while ((buf = bufferedReader.readLine()) != null) {
                outputStream.write(buf.getBytes());
            }

            outputStream.close();
            socket.close();
        }
        serverSocket.close();


    }
}
