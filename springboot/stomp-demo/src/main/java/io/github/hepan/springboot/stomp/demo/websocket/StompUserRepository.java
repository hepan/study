package io.github.hepan.springboot.stomp.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Null;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hp
 * @Description: 存储用户与资源的绑定关系，一个用户同一时间只占有一个资源。一个资源不可同时被两个用户占有
 * @date 2019-04-26 15:26
 */
@Component
public class StompUserRepository {
    private static final Logger log = LoggerFactory.getLogger(StompUserRepository.class);

    private static final Map<String , String> userRepo=new ConcurrentHashMap<>();
    private static final Map<String ,String>  resourceRepo=new ConcurrentHashMap<>();

    public boolean addUser(Principal principal){
        if(ObjectUtils.isEmpty(principal)){
            return false;
        }
        userRepo.put(principal.getName(), "");
        return true;
    }

    /**
     * 为user添加resource，
     * @param principal
     * @param resource
     * @return true：添加成功
     *         false：1->resource已被占有。2->入参为null或""。
     */
    public boolean addRepo(Principal principal,String resource){
        if(ObjectUtils.isEmpty(principal)||StringUtils.isEmpty(resource)){
            return false;
        }
        //已经被占有的资源返回错误
        String name=resourceRepo.get(resource);
        if(!StringUtils.isEmpty(name)){
            return false;
        }


        String resInRepo=userRepo.get(principal.getName());
        if(!StringUtils.isEmpty(resInRepo)){
            log.info("[SUR] name->[{}] resource from[{}] to[{}]",name,resInRepo,resource);
        }
        userRepo.put(principal.getName(),resource);
        resourceRepo.put(resource,principal.getName());

        return true;
    }


    /**
     * 释放user与user所占有resource
     * @param principal
     * @return
     */
    public boolean releaseUser(Principal principal){
        if(ObjectUtils.isEmpty(principal)){
            return false;
        }
        String resource=userRepo.get(principal.getName());
        userRepo.remove(principal);
        resourceRepo.remove(resource);
        return true;
    }

    /**
     * 释放resource并解除user与resource的绑定关系
     * @param resource
     * @return
     */
    public boolean releaseResource(Principal principal,String resource){
        if(StringUtils.isEmpty(resource)){
            log.info("[release-resource] 释放失败 资源isEmpty");
            return false;
        }
        if(!userRepo.containsKey(principal.getName())){
            log.info("[release-resource] 释放失败 资源中未找到[{}]",principal.getName());
            return false;
        }
        String name=resourceRepo.get(resource);
        if(!principal.getName().equalsIgnoreCase(name)){
            log.info("[release-resource] 释放失败 当前绑定资源用户与释放资源用户不一致 resource->{} from user->{} to->{}"
                    ,resource,name,principal.getName());
            return false;
        }

        resourceRepo.remove(resource);
        userRepo.put(name,null);
        return true;
    }
}
