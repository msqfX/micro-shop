package com.shop.portal.service;

import com.shop.pojo.Admin;

/**
 * Created By Lizhengyuan on 18-10-30
 */
public interface UserService {

    Admin login(String userNmae, String passWord);

}
