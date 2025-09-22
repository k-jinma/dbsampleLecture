package com.example.dbsample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dbsample.entity.Publisher;
import com.example.dbsample.form.AddForm;
import com.example.dbsample.mapper.BookMapper;
import com.example.dbsample.mapper.PublisherMapper;

import jakarta.validation.Valid;
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
    public String addBook(AddForm addForm,Model model){
        // ビューを表示する前に、出版社情報をDBから取得してモデルに追加
        List<Publisher> result = p.getAllPublishers();
        model.addAttribute("publishers", result);
        return "book/add";
    }

    @PostMapping("/add")
    public String postMethodName(
        @Valid AddForm addForm, // 説明: バリデーションを実行 addFormにはフォームの入力値がセットされている
        BindingResult bindingResult, // 説明: バリデーション結果を受け取る
        // @RequestParam("title") String title,
        // @RequestParam("author") String author,
        // @RequestParam("publisherId") int publisherId,
        Model model
    ) {
        
        if(bindingResult.hasErrors()){
            // エラー時は出版社リストを再セットして画面へ戻す
            // ビューを表示する前に、出版社情報をDBから取得してモデルに追加
            List<Publisher> result = p.getAllPublishers();
            model.addAttribute("publishers", result);
            return "book/add";
        }
        
        b.insertBook2(addForm.getTitle(), addForm.getAuthor(), addForm.getPublisherId());
        
        return "book/index";
    }
    


}
