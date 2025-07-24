package com.cc.mwu.service;

import com.cc.mwu.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 用户待办事项表(Todo)表服务接口
 *
 * @author makejava
 * @since 2025-07-22 20:10:53
 */
public interface TodoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Todo queryById(Integer id);

    /**
     * 根据用户openId查询多条数据
     * @param openid 用户openId
     * @return 多条数据
     */
    List<Todo> queryByOpenId(String openid);

    /**
     * 分页查询
     *
     * @param todo        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Todo> queryByPage(Todo todo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    Todo insert(Todo todo);

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    Todo update(Todo todo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
