package com.tencent.supersql.thrift;

import com.tencent.supersql.gen.SupersqlConnectionService;
import com.tencent.supersql.jdbc.SSqlSerivceImpl;
import org.apache.log4j.Logger;
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


        Logger logger  =  Logger.getLogger(SupersqlServer.class);

        Config.initConf();
        Config.initDrivers();
        ConnectionPool.init();
        SSMetaData.initSSMetaData();

        try {
            TServerSocket serverTransport = new TServerSocket(Config.supersqlServerPort);
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            TProcessor processor = new SupersqlConnectionService.Processor(new SSqlSerivceImpl());
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("========Start Supersql thrift server on port " + Config.supersqlServerPort + " =======");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
