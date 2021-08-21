package com.geeker.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



/**
 * @author: yoghurt
 * data:2021-08-21
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public List<String> Hello() {
        List<String> list = new ArrayList<>();
        list.add("12312");
        list.add("12312312");
        list.add("12312312");
        return list;
    }
}
