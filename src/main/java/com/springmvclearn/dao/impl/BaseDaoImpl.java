package com.springmvclearn.dao.impl;

import com.springmvclearn.dao.BaseDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    private String ns;

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public List<T> find(Map map) {
        List<T> olist = this.getSqlSession().selectList(ns + ".find", map);
        return olist;
    }

    public T get(Serializable id) {
        return this.getSqlSession().selectOne(ns + ".get", id);
    }

    public void insert(T entity) {
        this.getSqlSession().insert(ns + ".insert", entity);
    }

    @Override
    public void update(T entity) {
        this.getSqlSession().update(ns + ".update", entity);
    }

    @Override
    public void deleteById(Serializable id) {
        this.getSqlSession().delete(ns + ".deleteById", id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(ns + ".delete", ids);
    }
}
