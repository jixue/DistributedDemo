package rpc.rmi.business;

import java.rmi.RemoteException;

/**
 * RMI服务器端实现外部接口的类
 * Created by jx on 17/2/16.
 */
public class ServerInterfaceImpl implements ServerInterface{

    public String getServerResp(String message) throws RemoteException{
        System.out.println("Message from client : " + message);
        return "Server response : " + message;
    }
}
