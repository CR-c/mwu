package com.cc.mwu.dao;

import com.cc.mwu.entity.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户待办事项表(Todo)表数据库访问层
 *
 * @author makejava
 * @since 2025-07-22 20:10:53
 */
@Mapper
public interface TodoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Todo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param todo     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Todo> queryAllByLimit(Todo todo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param todo 查询条件
     * @return 总行数
     */
    long count(Todo todo);

    /**
     * 新增数据
     *
     * @param todo 实例对象
     * @return 影响行数
     */
    int insert(Todo todo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Todo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Todo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Todo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Todo> entities);

    /**
     * 修改数据
     *
     * @param todo 实例对象
     * @return 影响行数
     */
    int update(Todo todo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Todo> queryByOpenId(String openId);
}

