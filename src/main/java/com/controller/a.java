package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BF on 2017/8/24.
 */
@Controller
public class a {

    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    public String test(){
        System.out.println("进入");
        return "aa";

    }
}
