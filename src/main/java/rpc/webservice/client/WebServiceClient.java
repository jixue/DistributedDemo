package rpc.webservice.client;

/**
 * WebService客户端；
 * <pre>
 *     wsimport -keep http://localhost:8084/BusinessService\?wsdl
 * </pre>
 * 生成客户端辅助代码
 * Created by jx on 17/2/17.
 */
public class WebServiceClient {
    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();
        Business business = businessService.getBusinessPort();
        String message = "hello world!";
        business.echo(message);
    }
}
