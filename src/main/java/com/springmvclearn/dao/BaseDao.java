package com.springmvclearn.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
// 数据库基本增删改查接口
public interface BaseDao<T> {
    // 根据id查询一条数据
    public T get(Serializable identifier);
    // 根据条件查询返回多个结果
    public List<T> find(Map map);
    // 插入 用实体作为参数
    public void insert(T entity);
    // 修改 用实体作为参数
    public void update(T entity);
    // 根据id删除一条数据
    public void deleteById(Serializable id);
    // 批量删除数据
    public void delete(Serializable[] ids);
}
