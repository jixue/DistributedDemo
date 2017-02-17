package rpc.rmi.business;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI服务器端对外提供的接口；
 * 接口需继承Remote接口，接口中方法必须抛出RemoteException异常。
 * Created by jx on 17/2/16.
 */
public interface ServerInterface extends Remote{

    public String getServerResp(String message) throws RemoteException;
}
