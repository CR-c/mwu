package com.cc.mwu.service.impl;

import com.cc.mwu.entity.Todo;
import com.cc.mwu.dao.TodoDao;
import com.cc.mwu.service.TodoService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户待办事项表(Todo)表服务实现类
 *
 * @author makejava
 * @since 2025-07-22 20:10:53
 */
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    @Resource
    private TodoDao todoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Todo queryById(Integer id) {
        return this.todoDao.queryById(id);
    }

    @Override
    public List<Todo> queryByOpenId(String openId) {
        return this.todoDao.queryByOpenId(openId);
    }

    /**
     * 分页查询
     *
     * @param todo        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Todo> queryByPage(Todo todo, PageRequest pageRequest) {
        long total = this.todoDao.count(todo);
        return new PageImpl<>(this.todoDao.queryAllByLimit(todo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    @Override
    public Todo insert(Todo todo) {
        this.todoDao.insert(todo);
        return todo;
    }

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 实例对象
     */
    @Override
    public Todo update(Todo todo) {
        this.todoDao.update(todo);
        return this.queryById(todo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.todoDao.deleteById(id) > 0;
    }
}
