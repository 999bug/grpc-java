package client.stater;

import client.service.BaseService;
import client.service.BaseServiceImpl;

/**
 * @author Lsy
 * @date 2022/2/18
 */
public class Client {
    public static void main(String[] args) {
        BaseService client = new BaseServiceImpl("127.0.0.1", 10086);
        client.sayHello("我是小区保安，你好");
        client.shutdown();
    }
}
