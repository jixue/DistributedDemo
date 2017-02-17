package protocol.channel;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * 基于Channel和Selector实现TCP/IP+NIO的系统间通信，Reactor模式；
 * 客户端
 * Created by jx on 17/2/14.
 */
public class NIOClient {

    private static Logger logger = Logger.getLogger(NIOClient.class);

    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);//设置为非阻塞模式
        }catch (IOException e){
            logger.warn("连接失败：" + e);
        }
    }
}
