package com.shop.dao;

import com.shop.Example.ItemParamExample;
import com.shop.pojo.ItemParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemParamMapper {
    long countByExample(ItemParamExample example);

    int deleteByExample(ItemParamExample example);

    int insert(ItemParam record);

    int insertSelective(ItemParam record);

    List<ItemParam> selectByExampleWithBLOBs(ItemParamExample example);

    List<ItemParam> selectByExample(ItemParamExample example);

    int updateByExampleSelective(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    int updateByExample(@Param("record") ItemParam record, @Param("example") ItemParamExample example);
}