package io.github.hepan.rpc.hessian.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 17:03
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {
    private int id;
    private String name;
    private List<String> nickName;
    private UserTypeEnum type;

}
