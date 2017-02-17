package rpc.rmi.server;

import org.apache.log4j.Logger;
import rpc.rmi.business.ServerInterface;
import rpc.rmi.business.ServerInterfaceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI服务器端
 * Created by jx on 17/2/16.
 */
public class RMIServer {

    private static Logger logger = Logger.getLogger(RMIServer.class);

    public static void main(String[] args) {
        int port = 8082;
        String registerName = "BusinessDemo";
        ServerInterface serverInterface = new ServerInterfaceImpl();
        try {
            UnicastRemoteObject.exportObject(serverInterface, port);//将对象绑定到端口上
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind(registerName, serverInterface);//将对象注册到LocateRegistry
        }catch (RemoteException re){
            logger.error("将对象绑定到端口上出错：", re);
        }catch (AlreadyBoundException abe){
            logger.error("将对象注册到LocateRegistry上出错：", abe);
        }
    }
}
