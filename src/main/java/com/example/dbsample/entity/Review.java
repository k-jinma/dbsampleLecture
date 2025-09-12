package com.example.dbsample.entity;

import lombok.Data;

@Data
public class Review {
    // レビューID
    private int id;
    // 書籍ID
    private int bookId;
    // レビュー内容
    private String reviewText;
}
