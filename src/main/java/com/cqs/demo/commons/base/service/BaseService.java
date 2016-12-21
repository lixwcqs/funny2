package com.cqs.demo.commons.base.service;

import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public interface BaseService<PK, T> extends BaseServiceView<T> {

    T findById(PK id);//根据主键查询

    int insert(T entity);//插入一条记录

    void batchInsert(List<T> list);

}
