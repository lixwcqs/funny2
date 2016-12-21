package com.cqs.demo.commons.base.service;

import com.cqs.demo.commons.base.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public abstract class BaseServiceImpl<PK, T> extends BaseServiceViewImpl<T> implements BaseService<PK, T> {

    private final int batchSize = 100;

    protected abstract BaseDao<PK, T> getBaseDao();

    @Override
    public T findById(PK id) {
        return getBaseDao().findById(id);
    }

    @Transactional
    @Override
    public int insert(T entity) {
        return getBaseDao().insert(entity);
    }

    @Transactional
    @Override
    public void batchInsert(List<T> list) {
        if (list == null || list.size() == 0) return;
        //分批写入
        int start = 0;
        int end = 0;
        while (end < list.size()) {
            end += Math.min(batchSize, list.size() - end);
            getBaseDao().batchInsert(list.subList(start, end));
            start = end;
        }
    }
}
