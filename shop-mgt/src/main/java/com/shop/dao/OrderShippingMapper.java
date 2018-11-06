package com.shop.dao;

import com.shop.Example.OrderShippingExample;
import com.shop.pojo.OrderShipping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderShippingMapper {
    long countByExample(OrderShippingExample example);

    int deleteByExample(OrderShippingExample example);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    List<OrderShipping> selectByExample(OrderShippingExample example);

    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);
}