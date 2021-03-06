package client.service;

import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * @author Lsy
 * @date 2022/2/21
 */
public class ServerService {
    private static final int port = 10086;
    private static io.grpc.Server server;

    public static void start() throws IOException, InterruptedException {
        server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl())
                // 设置服务器上允许接收的最大邮件大小。如果未调用，则默认为4 MiB，所以要设置此参数
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .build()

                .start();
        System.out.println("server start port: " + port);
        server.awaitTermination();
    }

}
