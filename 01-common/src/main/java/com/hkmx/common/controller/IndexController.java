package com.hkmx.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2020/9/1 17:10
 */
@Slf4j
@RequestMapping("/index")
@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

}
