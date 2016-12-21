package com.cqs.demo.commons.base.service;

import com.cqs.demo.commons.base.dao.BaseDaoView;

import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public abstract class BaseServiceViewImpl<T> implements BaseServiceView<T> {

    protected abstract BaseDaoView<T> getBaseDao();

    @Override
    public List<T> queryAll() {
        return getBaseDao().queryAll();
    }
}
