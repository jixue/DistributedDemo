package rpc.rmi.client;

import org.apache.log4j.Logger;
import rpc.rmi.business.ServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端
 * Created by jx on 17/2/16.
 */
public class RMIClient {

    private static Logger logger = Logger.getLogger(RMIClient.class);

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            String registryName = "BusinessDemo";
            String messgae = "hello server!";
            ServerInterface serverInterface = (ServerInterface) registry.lookup(registryName);
            serverInterface.getServerResp(messgae);
        }catch (RemoteException re){
            logger.error("连接失败：", re);
        }catch (NotBoundException nbe){
            logger.error("服务器端没有对应名称的绑定：", nbe);
        }
    }
}
