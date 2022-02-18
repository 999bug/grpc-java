package client.service;

import client.grpc.HelloGrpc;
import client.grpc.protobuf.HelloRequest;
import client.grpc.protobuf.HelloResponse;
import io.grpc.stub.StreamObserver;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class HelloServiceImpl extends HelloGrpc.HelloImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setMessage("我是业主小安，爱吃小熊饼干")
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
        System.out.println("收到消息：" + request.getName());
    }
}
