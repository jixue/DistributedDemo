package protocol.socket.tcp;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

/**
 * 基于Socket、ServerSocket实现TCP/IP+BIO的系统间通信;
 * 客户端Client
 * Created by jx on 17/2/13.
 */
public class TCPSocketClient {
	  private static Logger logger = Logger.getLogger(TCPSocketClient.class);

	  public static void main(String[] args) {
	  	  try {
			  //1.创建客户端，指定服务器地址和端口
			  Socket socket = new Socket("127.0.0.1", 8080);

			  //2.获取输出流，向服务器发送消息
			  OutputStream os = socket.getOutputStream();
			  PrintWriter out = new PrintWriter(os, true);
			  out.println("hello socket");//写失败也不会抛出异常，一直阻塞到写成功或网络IO出现异常为止
			  out.flush();
			  socket.shutdownOutput();

			  //3.获取输入流，读取服务器的响应信息
			  InputStream is = socket.getInputStream();
			  BufferedReader in = new BufferedReader(new InputStreamReader(is));
			  String str = null;
			  while((str = in.readLine()) != null){
				  logger.info("服务器响应信息: " + str);
			  }

			  //4.关闭资源
			  in.close();
			  is.close();
			  out.close();
			  os.close();
			  socket.close();

		  }
		  catch (IOException e) {
		  	  logger.error("socket连接出错", e);
		  }
	  }
}
