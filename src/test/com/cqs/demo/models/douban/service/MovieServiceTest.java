package com.cqs.demo.models.douban.service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cqs.demo.commons.base.service.BaseService;
import com.cqs.demo.models.douban.entity.Movie;
import org.junit.Test;

/**
 * Created by cqs on 16-12-14.
 */
public class MovieServiceTest {
    @Test
    public void findByName() throws Exception {
        String url = "http://hessian.caucho.com/test/test";

        HessianProxyFactory factory = new HessianProxyFactory();
        @SuppressWarnings("unchecked")
        BaseService<Integer, Movie> basic = (BaseService<Integer, Movie>) factory.create(BaseService.class, url);

        System.out.println("hello(): " + basic.findById(30));
    }

    @Test
    public void findTitleAndRateById() throws Exception {

    }

}