package com.springmvclearn.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
// 数据库基本增删改查接口
public interface BaseDao<T> {
    public T get(Serializable identifier);
    public List<T> find(Map map);
    public void insert(T entity);
    public void update(T entity);
    public void deleteById(Serializable id);
    public void delete(Serializable[] ids);
}
