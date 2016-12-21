package com.cqs.demo.commons.base.dao;

import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public interface BaseDaoView<T> {
    List<T> queryAll();
}
