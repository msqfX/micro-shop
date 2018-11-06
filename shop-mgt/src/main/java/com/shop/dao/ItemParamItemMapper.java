package com.shop.dao;

import com.shop.Example.ItemParamItemExample;
import com.shop.pojo.ItemParamItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemParamItemMapper {
    long countByExample(ItemParamItemExample example);

    int deleteByExample(ItemParamItemExample example);

    int insert(ItemParamItem record);

    int insertSelective(ItemParamItem record);

    List<ItemParamItem> selectByExampleWithBLOBs(ItemParamItemExample example);

    List<ItemParamItem> selectByExample(ItemParamItemExample example);

    int updateByExampleSelective(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    int updateByExample(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);
}