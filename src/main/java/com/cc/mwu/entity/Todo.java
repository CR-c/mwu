package com.cc.mwu.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * 用户待办事项表(Todo)实体类
 *
 * @author makejava
 * @since 2025-07-22 20:10:53
 */
@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 487070320939842253L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 待办标题
     */
    private String title;
    /**
     * 待办内容
     */
    private String content;
    /**
     * 任务状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}

