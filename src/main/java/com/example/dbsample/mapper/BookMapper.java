package com.example.dbsample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dbsample.entity.Book;


@Mapper
public interface BookMapper {
    List<Book> getAllBooks();

    @Insert("INSERT INTO books (title, author, publisher_id) VALUES (#{title}, #{author}, #{publisherId})")
    void insertBook2(@Param("title") String title, @Param("author") String author, @Param("publisherId") int publisherId);
    
}
