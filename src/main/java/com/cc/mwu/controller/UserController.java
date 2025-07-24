package com.cc.mwu.controller;

import com.cc.mwu.common.Result;
import com.cc.mwu.entity.User;
import com.cc.mwu.service.UserService;
import com.cc.mwu.service.WechatAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信用户表(User)表控制层
 *
 * @author makejava
 * @since 2025-07-20 21:44:08
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private WechatAuthService wechatAuthService;


    @GetMapping("/getUserInfo")
    public Result<User> getUserInfo(@RequestParam String openId){
        User user = userService.getUserInfoByOpenId(openId);
        if(user == null){
            return Result.fail(909,"用户不存在");
        }
        return Result.success(user);
    }

    @PostMapping("/wechatLogin")
    public Result<Map<String, Object>> wechatLogin(@RequestParam String code) {
        log.debug("wechatLogin : code:{}",code);
        // 调用WechatAuthService获取openid
        String openId = wechatAuthService.getOpenId(code);

        // 用户信息处理
        User user = userService.findOrCreateUser(openId);
//
//        // 生成访问令牌
//        String token = jwtUtils.generateToken(user);

        // 返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("userInfo", user);
//        result.put("accessToken", token);
        return Result.success(result);
    }

}

