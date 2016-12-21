package com.cqs.demo.commons.base.service;

import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public interface BaseServiceView<T> {

    List<T> queryAll();

}
