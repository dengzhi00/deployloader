package com.dzm.loader.impl;

import com.dzm.loader.service.TestService;

/**
 * @author 邓治民
 *         data 2018/4/16 下午3:29
 */

public class TestServiceImpl implements TestService{

    @Override
    public String test() {
        return "services  test";
    }
}
