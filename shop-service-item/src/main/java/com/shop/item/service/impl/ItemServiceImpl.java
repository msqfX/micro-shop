package com.shop.item.service.impl;

import com.shop.Example.ItemDescExample;
import com.shop.Example.ItemExample;
import com.shop.item.service.ItemService;
import com.shop.mapper.ItemDescMapper;
import com.shop.mapper.ItemMapper;
import com.shop.pojo.Item;
import com.shop.pojo.ItemDesc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@Api(value = "API - ItemServiceImpl", description = "商品操作")
@RestController
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    @ApiOperation("获取商品信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "itemId", value = "", required = true, dataType = "Long"),
            }
    )
    public Object getItemById(String id) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdEqualTo(Long.parseLong(id));
        List<Item> items = itemMapper.selectByExample(itemExample);
        return items.isEmpty() ? null : items.get(0);
    }

    @Override
    public Object getItemDescById(String id) {
        ItemDescExample itemDescExample = new ItemDescExample();
        ItemDescExample.Criteria criteria = itemDescExample.createCriteria();
        criteria.andItemIdEqualTo(Long.parseLong(id));
        List<ItemDesc> itemDescList = itemDescMapper.selectByExample(itemDescExample);
        return itemDescList.isEmpty() ? null : itemDescList.get(0);
    }


}
