package rpc.webservice.server;


import rpc.webservice.business.Business;
import rpc.webservice.business.BusinessWsImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by jx on 17/2/17.
 */
public class WebServiceServer {

    public static void main(String[] args) {
        Business business = new BusinessWsImpl();
        Endpoint.publish("http://localhost:8084/BusinessService?wsdl", business);
        System.out.println("Server has been started!");
    }
}
