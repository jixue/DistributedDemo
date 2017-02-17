package protocol.socket.udp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 基于Socket、ServerSocket实现TCP/IP+BIO的系统间通信;
 * 客户端Client
 * Created by jx on 17/2/14.
 */
public class UDPSocketClient {

    private static Logger logger = Logger.getLogger(UDPSocketClient.class);

    public static void main(String[] args) {
        try {
            PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/log4j.properties");

            //向服务器发送消息
            //1.定义客户端地址、端口号、数据
            byte[] sendData = "hello server.".getBytes();
            InetAddress address = InetAddress.getLocalHost();
            int port = 8081;
            //2.创建数据报，包含响应的数据信息
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
            //3.向服务器发送数据
            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.send(packet);

            //接受服务器端的响应数据
            //1.创建数据报，接受服务器端的响应数据
            byte[] receiveData = new byte[1024];
            packet = new DatagramPacket(receiveData, receiveData.length);
            //2.接受服务器端响应的数据
            clientSocket.receive(packet);
            //4.读取数据
            String info = new String(receiveData);
            logger.info("服务器端返回数据：：" + info);
            //4.关闭资源
            clientSocket.close();
        }catch (SocketException se){
            logger.error("UDP socket连接失败：", se);
        }catch (IOException ioe){
            logger.error("向服务器端发送数据失败：", ioe);
        }
    }
}
