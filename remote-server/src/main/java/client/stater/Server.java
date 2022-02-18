package client.stater;

import client.service.HelloServiceImpl;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class Server {
    private static final int port = 10086;
    private static io.grpc.Server server;

    private static void start() throws IOException, InterruptedException {
        server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl())
                // 设置服务器上允许接收的最大邮件大小。如果未调用，则默认为4 MiB，所以要设置此参数
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .build()

                .start();
        System.out.println("server start port: " + port);
        server.awaitTermination();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }
}
