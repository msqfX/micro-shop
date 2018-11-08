package com.shop.mapper;

import com.shop.Example.ItemCatExample;
import com.shop.pojo.ItemCat;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemCatMapper {
    long countByExample(ItemCatExample example);

    int deleteByExample(ItemCatExample example);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    List<ItemCat> selectByExample(ItemCatExample example);

    int updateByExampleSelective(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    int updateByExample(@Param("record") ItemCat record, @Param("example") ItemCatExample example);
}