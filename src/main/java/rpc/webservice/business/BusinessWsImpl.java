package rpc.webservice.business;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by jx on 17/2/17.
 */
@WebService(name = "Business",serviceName = "BusinessService",
        targetNamespace = "http://webservice.business/client")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BusinessWsImpl implements Business {

    public String echo(String message){
        System.out.println("Message from client : " + message);
        return "Server response : " + message;
    }
}
