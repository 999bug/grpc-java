package client.service;


import client.grpc.HelloGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public abstract class BaseService {

    protected final ManagedChannel channel;
    protected final HelloGrpc.HelloBlockingStub blockingStub;

    public BaseService(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                // 传输的数据大于4MB时，需要指定此参数
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .build();
        blockingStub = HelloGrpc.newBlockingStub(channel);
    }

    public void shutdown() {
        try {
            channel.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void sayHello(String str);
}
