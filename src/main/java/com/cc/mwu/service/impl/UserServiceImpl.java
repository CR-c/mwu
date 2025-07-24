package com.cc.mwu.service.impl;

import com.cc.mwu.entity.User;
import com.cc.mwu.dao.UserDao;
import com.cc.mwu.expection.BusinessException;
import com.cc.mwu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 微信用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2025-07-20 21:44:11
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserInfoByOpenId(String openId) {
        return this.userDao.queryByOpenId(openId);
    }

    @Override
    public User findOrCreateUser(String openId) {
        try {
            // 查询现有用户
            User user = this.userDao.queryByOpenId(openId);

            if (user == null) {
//            LOGGER.info("创建新微信用户，openId: {}", openId);
                user = new User();
                user.setOpenId(openId);
//            user.setCreateTime(LocalDateTime.now());
//            user.setLastLogin(LocalDateTime.now());
                boolean rslt = userDao.addUserInfo(user);
                if (!rslt) {
                    throw new Exception("创建失败");
                }

            } else {
                // 更新最后登录时间
//                user.setLastLogin(LocalDateTime.now());
//                userDao.updateLastLogin(user.getId(), LocalDateTime.now());
            }
            return user;
        } catch (Exception e) {
            log.error(e.getMessage());
            // LOGGER.error("用户操作失败，openId: {}，错误信息: {}", openId, e.getMessage());
            throw new BusinessException("用户操作失败");
        }
    }

    @Override
    public boolean addUserInfo(User user) {
        return this.userDao.addUserInfo(user);
    }
}
