package com.example.dbsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {

    // メニュー画面表示
    @GetMapping("/")
    public String showIndex(){
        return "book/index";
    }

}
