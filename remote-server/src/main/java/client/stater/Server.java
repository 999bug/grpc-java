package client.stater;

import client.service.ServerService;

import java.io.IOException;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerService.start();
    }
}
