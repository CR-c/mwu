# 微信小程序用户模型

## 实体类设计
```java
public class WechatUser {
    // 用户唯一标识（小程序openid）
    private String openId; 
    
    // 用户昵称 
    private String nickName;
    
    // 头像URL
    private String avatarUrl;
    
    // 性别 0-未知 1-男性 2-女性
    private Integer gender;
    
    // 地区信息
    private String city;
    private String province;
    private String country;
    
    // 联合ID（跨平台标识）
    private String unionId;
    
    // 手机号码
    private String phone;
    
    // 时间信息
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime;
}
```

## SQL建表语句
```sql
CREATE TABLE 'user' (
  `openid` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `nick_name` varchar(64) DEFAULT '' COMMENT '用户昵称',
  `avatar_url` varchar(255) DEFAULT '' COMMENT '用户头像',
  `gender` tinyint(1) DEFAULT 0 COMMENT '性别',
  `city` varchar(20) DEFAULT '' COMMENT '城市',
  `province` varchar(20) DEFAULT '' COMMENT '省份',
  `country` varchar(20) DEFAULT '' COMMENT '国家',
  `unionid` varchar(32) DEFAULT '' COMMENT '联合ID',
  `phone` varchar(20) DEFAULT '' COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`openid`),
  UNIQUE KEY `idx_unionid` (`unionid`),
  UNIQUE KEY `idx_phone` (`phone`),
  KEY `idx_createtime` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信用户表';
```

执行以下命令创建文件：
```bash
New-Item -Path "md/wechat_user_schema.md" -ItemType File
```

**扩展建议**：
1. 敏感字段（如openid/unionid）建议加密存储
2. 可添加is_deleted字段实现软删除
3. 根据业务需求添加session_key存储字段"
    }
  }
}