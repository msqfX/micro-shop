package com.shop.mapper;

import com.shop.pojo.ItemParamItem;
import com.shop.Example.ItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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