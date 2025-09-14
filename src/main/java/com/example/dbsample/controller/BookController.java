package com.example.dbsample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dbsample.entity.Publisher;
import com.example.dbsample.mapper.BookMapper; // 追加
import com.example.dbsample.mapper.PublisherMapper;

import lombok.RequiredArgsConstructor;




@Controller
@RequiredArgsConstructor
public class BookController {
    
    private final BookMapper b;
    private final PublisherMapper p;

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
    

    /**
     * 書籍追加画面表示
     */
    // @GetMapping("/add")
    // public String addBook(Model model) {
    //     model.addAttribute("publishers", publisherMapper.getAllPublishers()); // 追加
    //     return "book/add";
    // }
    


    @GetMapping("/add")
    public String addBook(Model model){
        // ビューを表示する前に、出版社情報をDBから取得してモデルに追加
        List<Publisher> result = p.getAllPublishers();
        model.addAttribute("publishers", result);
        return "book/add";
    }

    @PostMapping("/add")
    public String postMethodName(
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("publisherId") int publisherId,
        Model model
    ) {
        b.insertBook2(title, author, publisherId);

        return "book/index";
    }
    


}
