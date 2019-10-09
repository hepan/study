package io.github.hepan.springboot.thread.executor.demo.my.sender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:36
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageBean {

    private String id;
    private String message;
}
