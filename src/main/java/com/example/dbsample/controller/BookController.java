package com.example.dbsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    // 書籍一覧表示
    @GetMapping("/list")
    public String showAllBooks(Model model){
        model.addAttribute("message","一覧表示");
        model.addAttribute("books", bookMapper.getAllBooks());
        return "book/success";
    }

    @GetMapping("/detail/{id}")
    public String getMethodName(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "詳細表示");
        model.addAttribute("book", bookMapper.getBookById(id));
        return "book/success";
    }
    

}
