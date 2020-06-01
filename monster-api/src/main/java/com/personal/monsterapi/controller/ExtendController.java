package com.personal.monsterapi.controller;

import com.personal.monsterapi.consumer.DubboConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ExtendController {
    @Autowired
    private DubboConsumer dubboConsumer;

    @RequestMapping("echoService")
    public Object echoService(String echo){
        return dubboConsumer.testEchoService(echo);
    }

    @RequestMapping("callback")
    public Object callback(){
        return dubboConsumer.callback();
    }
}
