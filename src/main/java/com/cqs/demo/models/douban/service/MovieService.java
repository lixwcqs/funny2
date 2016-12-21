package com.cqs.demo.models.douban.service;

import com.cqs.demo.commons.base.service.BaseService;
import com.cqs.demo.models.douban.entity.Movie;

import java.util.List;

/**
 * Created by cqs on 10/15/16.
 */
public interface MovieService extends BaseService<Integer, Movie> {
    List<Movie> findByName(String title);//根据名称查询电影

    Movie findTitleAndRateById(int id);//根据主键查询电影
}