package com.cc.mwu.service;

import com.cc.mwu.entity.User;

/**
 * 微信用户表(User)表服务接口
 *
 * @author makejava
 * @since 2025-07-20 21:44:10
 */
public interface UserService {

    User getUserInfoByOpenId(String openId);

    User findOrCreateUser(String openId);

    boolean addUserInfo(User user);


}
