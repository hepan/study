package io.github.hepan.rpc.thrift.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 13:31
 **/
@Component
@Slf4j
public class ThriftServer {
    @Value("${thrift.port}")
    private int port;
    @Value("${thrift.minWorkerThreads}")
    private int minThreads;
    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;
    @Autowired
    private JazzRpcController jazzRpcController;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;


    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    public void start() {
        //TMultiplexedProcessor processor = new TMultiplexedProcessor();

        //processor.registerProcessor(JazzService.class.getSimpleName(), new JazzService.Processor<JazzService.Iface>(hadoopService));

        JazzService.Processor processor = new JazzService.Processor<JazzService.Iface>(jazzRpcController);
        init();
        try {
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            //TServer server = new TSimpleServer(tArgs);
            log.info("thrift服务启动成功, 端口={}", port);
            server.serve();
        } catch (Exception e) {
            log.error("thrift服务启动失败", e);
        }

    }
}
