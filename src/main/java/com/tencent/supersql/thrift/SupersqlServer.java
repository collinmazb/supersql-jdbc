package com.tencent.supersql.thrift;

import com.tencent.supersql.gen.SupersqlConnectionService;
import com.tencent.supersql.jdbc.SSqlSerivceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by waixingren on 2/27/17.
 */
public class SupersqlServer {

    public static void main(String[] args) {

        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new SupersqlConnectionService.Processor(new SSqlSerivceImpl());
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
