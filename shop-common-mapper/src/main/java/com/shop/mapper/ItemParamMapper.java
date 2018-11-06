package com.shop.mapper;

import com.shop.pojo.ItemParam;
import com.shop.Example.ItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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