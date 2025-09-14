package com.example.dbsample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dbsample.entity.Publisher;

@Mapper
public interface PublisherMapper {
    @Select("SELECT * FROM PUBLISHERS")
    List<Publisher> getAllPublishers();
}
