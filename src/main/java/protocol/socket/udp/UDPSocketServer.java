package protocol.socket.udp;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 基于Socket、ServerSocket实现TCP/IP+BIO的系统间通信;
 * 服务器Server
 * Created by jx on 17/2/14.
 */
public class UDPSocketServer {

    private static Logger logger = Logger.getLogger(UDPSocketServer.class);

    public static void main(String[] args) {
        try {
            //接受客户端发送的数据
            //1.创建服务器端，指定端口
            DatagramSocket serverSocket = new DatagramSocket(8081);
            //2.创建数据报，接受客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //3.接受客户端发送的数据
            serverSocket.receive(packet);
            //4.读取数据
            String info = new String(data);
            logger.info("客户端发送数据：" + info);

            //向客户端响应数据
            //1.定义客户端地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] sendData = "hello client.".getBytes();
            //2.创建数据报，包含响应的数据信息
            packet = new DatagramPacket(sendData, sendData.length, address, port);
            //3.响应客户端
            serverSocket.send(packet);
            //4.关闭资源
            serverSocket.close();
        }catch (SocketException se){
            logger.error("UDP socket连接失败：", se);
        }catch (IOException ioe){
            logger.error("接受客户端发送数据失败：", ioe);
        }
    }
}
