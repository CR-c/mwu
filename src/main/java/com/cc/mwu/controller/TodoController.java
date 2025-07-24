package com.cc.mwu.controller;

import com.cc.mwu.common.Result;
import com.cc.mwu.entity.Todo;
import com.cc.mwu.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户待办事项表(Todo)表控制层
 *
 * @author makejava
 * @since 2025-07-22 20:10:52
 */
@RestController
@RequestMapping("/todo")
public class TodoController {
    /**
     * 服务对象
     */
    @Resource
    private TodoService todoService;

    /**
     * 分页查询
     *
     * @param todo        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public Result<Page<Todo>> queryByPage(Todo todo, PageRequest pageRequest) {
        return Result.success(this.todoService.queryByPage(todo, pageRequest));
    }




    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<Todo> queryById(@PathVariable("id") Integer id) {
        return Result.success(this.todoService.queryById(id));
    }

    /**
     * 根据用户openId查询多条数据
     * @param openId 用户openId
     * @return 多条数据
     */
    @GetMapping("/getList/{openId}")
    public Result<List<Todo>> queryByOpenId(@PathVariable("openId") String openId) {
        return Result.success(this.todoService.queryByOpenId(openId));
    }

    /**
     * 新增数据
     *
     * @param todo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result<Todo> add(@RequestBody Todo todo) {
        return Result.success(this.todoService.insert(todo));
    }


    /**
     * 编辑数据
     *
     * @param todo 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<Todo> edit(Todo todo) {
        return Result.success(this.todoService.update(todo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Integer id) {
        return Result.success(this.todoService.deleteById(id));
    }

}

