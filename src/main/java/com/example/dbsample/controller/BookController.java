package com.example.dbsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dbsample.mapper.BookMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
    
    private final BookMapper b;

    // メニュー画面表示
    @GetMapping("/")
    public String showIndex(){

        return "book/index";
    }

    @GetMapping("/list")
    public String showAllBooks(Model model){

        model.addAttribute("message", "一覧表示");
        model.addAttribute("books", b.getAllBooks());

        return "book/success";
    }

}
