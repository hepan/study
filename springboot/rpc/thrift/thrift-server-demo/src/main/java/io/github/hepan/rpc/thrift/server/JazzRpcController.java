package io.github.hepan.rpc.thrift.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 13:25
 **/
@Controller
@Slf4j
public class JazzRpcController implements JazzService.Iface {
    @Override
    public boolean exists(String path) throws TException {
        log.info("入参：{}", path);
        return true;
    }
}
