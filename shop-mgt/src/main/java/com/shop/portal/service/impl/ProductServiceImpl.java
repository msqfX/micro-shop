package com.shop.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.Example.ItemExample;
import com.shop.mapper.ItemMapper;
import com.shop.pojo.Item;
import com.shop.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Lizhengyuan on 18-10-31
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Object listProduct() {
        ItemExample itemExample = new ItemExample();
        PageHelper.startPage(1,20);
        List<Item> itemList = itemMapper.selectByExample(itemExample);
        PageInfo<Item> pageInfo = new PageInfo<>(itemList);
        long total  = pageInfo.getTotal();
        Map<String, Object> result = new HashMap<>();
        result.put("sEcho", 10);
        result.put("aData", itemList);
        result.put("iTotalRecords", total);
        result.put("iTotalDisplayRecords", 10);
        return result;
    }
}
