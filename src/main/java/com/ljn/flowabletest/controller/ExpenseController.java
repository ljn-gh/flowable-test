package com.ljn.flowabletest.controller;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author lijianan
 * @date 2021-08-11 19:03
 * @description
 */
@Controller
@RequestMapping("/workflow")
public class ExpenseController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;

    @GetMapping("/start")
    public String startEngine(){
        //启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test", new HashMap<>());
        return "提交成功.流程Id为：" + processInstance.getId();
    }



}
