package com.example.dbsample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dbsample.entity.Book;


@Mapper
public interface BookMapper {
    List<Book> getAllBooks();
}
