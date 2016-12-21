package com.yingjun.ssm.web;

import org.springframework.ui.Model;

/**
 * Created by cqs on 16-12-14.
 */
public interface IUserController {

    String list(Model model, Integer offset, Integer limit);
}