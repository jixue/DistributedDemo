package protocol.socket.tcp;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于Socket、ServerSocket实现TCP/IP+BIO的系统间通信;
 * 服务端Server
 * Created by jx on 17/2/13.
 */
public class TCPSocketServer {

    private static Logger logger = Logger.getLogger(TCPSocketServer.class);

    public static void main(String[] args) {
        try {
            //1.创建服务器端，指定绑定端口并监听
            ServerSocket serverSocket = new ServerSocket(8080);

            //2.accept()方法开始监听，等待客户端连接
            Socket socket = serverSocket.accept();

            //3.获取输入流，读取客户端信息
            InputStream is = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = in.readLine()) != null){
                logger.info("客户端发送数据: " + info);
            }
            socket.shutdownInput();

            //4.获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("hello socketServer!");
            pw.flush();

            //5.关闭资源
            pw.close();
            os.close();
            in.close();
            is.close();
            socket.close();
            serverSocket.close();

        }catch (IOException e){
            logger.error("服务器端创建失败:", e);
        }
    }
}
