package client.service;


import client.grpc.protobuf.HelloRequest;
import client.grpc.protobuf.HelloResponse;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class BaseServiceImpl extends BaseService {

    public BaseServiceImpl(String host, int port) {
        super(host, port);
    }

    @Override
    public void sayHello(String str) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(str)
                .build();
        HelloResponse response;
        response = blockingStub.sayHello(request);
        System.out.println("message from Grpc-server: " + response.getMessage());
        System.out.println();
    }

}
