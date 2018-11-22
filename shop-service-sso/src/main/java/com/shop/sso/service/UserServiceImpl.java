package com.shop.sso.service;

import com.alibaba.fastjson.JSON;
import com.shop.Example.UserExample;
import com.shop.common.RespResult;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.utils.JedisClient;
import com.shop.utils.MD5Util;
import com.shop.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * Created By Lizhengyuan on 18-11-20
 */
@RestController
public class UserServiceImpl implements UserService {

    @Value("${redisKey.expire_time}")
    private Integer EXPIRE_TIME;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public RespResult login(String sessionId, String userName, String passWord) {
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
        //存入reids
        jedisClient.set(sessionId, JSON.toJSONString(userList.get(0)));
        return RespResult.build(200,"登录成功");
    }
}
