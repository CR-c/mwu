package com.cc.mwu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class WechatAuthService {
    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String appSecret;
    private static final String WECHAT_API_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public String getOpenId(String code) {
        log.debug("收到微信登录请求，code: {}", code);
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                WECHAT_API_URL, appId, appSecret, code);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject jsonObject = JSON.parseObject(response.getBody());
            return jsonObject.getString("openid");
        }
        throw new RuntimeException("微信认证失败: " + response.getBody());
    }
}