# 待办事项表设计文档

## 表结构说明

| 字段名      | 类型                                | 必填 | 默认值              | 说明                         |
|-------------|-------------------------------------|------|---------------------|----------------------------|
| id          | INT UNSIGNED                       | 是   | AUTO_INCREMENT     | 主键ID                     |
| open_id     | VARCHAR(255)                       | 是   | -                   | 微信用户唯一标识            |
| title       | VARCHAR(100)                       | 是   | -                   | 待办事项标题（最大100字符）  |
| content     | TEXT                               | 否   | NULL                | 待办事项详细内容             |
| status      | ENUM('pending','in_progress','completed') | 是 | pending            | 任务当前状态                |
| created_at  | DATETIME                           | 是   | CURRENT_TIMESTAMP   | 记录创建时间                |
| updated_at  | DATETIME                           | 是   | CURRENT_TIMESTAMP   | 最后更新时间                |

## 索引说明
- **PRIMARY KEY (id)**：主键索引
- **idx_openid (open_id)**：加速用户维度的查询
- **idx_created_at (created_at)**：按创建时间排序查询
- **idx_updated_at (updated_at)**：按最后更新时间排序查询

## 示例操作


CREATE TABLE `todo` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`openId` VARCHAR(255) NOT NULL COMMENT '用户唯一标识',
`title` VARCHAR(100) NOT NULL COMMENT '待办标题',
`content` TEXT COMMENT '待办内容',
`status` INT NOT NULL DEFAULT 1 COMMENT '任务状态',
`created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
INDEX `idx_openId` (`openId`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户待办事项表';