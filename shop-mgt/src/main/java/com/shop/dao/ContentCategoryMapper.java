package com.shop.dao;

import com.shop.Example.ContentCategoryExample;
import com.shop.pojo.ContentCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentCategoryMapper {
    long countByExample(ContentCategoryExample example);

    int deleteByExample(ContentCategoryExample example);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    List<ContentCategory> selectByExample(ContentCategoryExample example);

    int updateByExampleSelective(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);

    int updateByExample(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);
}