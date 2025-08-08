package com.example.dbsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dbsample.mapper.BookMapper;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BookController {

    // DI
    private final BookMapper bookMapper;

    // メニュー画面表示
    @GetMapping("/")
    public String showIndex(){
        return "book/index";
    }    

}
