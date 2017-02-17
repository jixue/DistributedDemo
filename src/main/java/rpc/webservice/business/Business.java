package rpc.webservice.business;

/**
 * Created by jx on 17/2/17.
 */
public interface Business {
    /**
     * 显示客户端提供的信息，并返回
     * @param message
     * @return
     */
    public String echo(String message);
}
