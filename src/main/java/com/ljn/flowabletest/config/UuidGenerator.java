package com.ljn.flowabletest.config;


import org.flowable.common.engine.impl.cfg.IdGenerator;

import java.util.UUID;

/**
 * @author lijianan
 * @date 2021-08-11 19:17
 * @description
 */
public class UuidGenerator implements IdGenerator {
    @Override
    public String getNextId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
