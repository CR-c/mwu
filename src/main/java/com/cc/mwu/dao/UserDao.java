package com.cc.mwu.dao;

import com.cc.mwu.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2025-07-20 21:44:08
 */

@Mapper
public interface UserDao {

    User queryByOpenId(String openid);


    boolean addUserInfo(User user);
}

