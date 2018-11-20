package com.shop.sso.service;

import com.shop.Example.UserExample;
import com.shop.common.RespResult;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Created By Lizhengyuan on 18-11-20
 */
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespResult login(String userName, String passWord) {
        if(Objects.isNull(userName)){
            return RespResult.build(400,"用户不存在");
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(example);

        if(!userList.isEmpty()){
            User loginUser = userList.get(0);
            if(!loginUser.getPassword().equals(MD5Util.getMD5Res(passWord))) {
                return RespResult.build(401,"密码错误");
            }
        }else {
            if(userList.isEmpty()){
                return RespResult.build(400,"用户不存在");
            }
        }
        //todo 存入reids

        return RespResult.build(200,"登录成功");
    }
}
