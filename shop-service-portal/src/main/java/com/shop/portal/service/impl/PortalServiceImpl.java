package com.shop.portal.service.impl;

import com.shop.Example.ItemCatExample;
import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.CatNode;
import com.shop.pojo.ItemCat;
import com.shop.portal.service.PortalService;
import com.shop.utils.JsonUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@Api(value = "API - PortalServiceImpl", description = "首页操作")
@RefreshScope
@Service
public class PortalServiceImpl implements PortalService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public Object getSortMenuList() {
        ItemCatExample example = new ItemCatExample();
        List<ItemCat> list = itemCatMapper.selectByExample(example);
        return list.isEmpty() ? list : convertSortNodeJson(list);

    }


    /**
     * 将分类列表转化未json数据
     * @param list
     * @return
     */
    private Object convertSortNodeJson(List<ItemCat> list){
        List<ItemCat> rootList = new ArrayList<>();
        List<ItemCat> nextList = new ArrayList<>();
        List<ItemCat> childList = new ArrayList<>();

        list.forEach( e -> {
            if(e.getIsParent()){
                if(e.getParentId() == 0){
                    rootList.add(e);
                }else {
                    nextList.add(e);
                }
            }else {
                childList.add(e);
            }
        });
        List<ItemCat> parentList = new ArrayList<>();
        if(rootList.size() > 14){
            parentList = rootList.subList(0,14);
        }
        List<CatNode> catNodes = new ArrayList<>();
        parentList.forEach( parentNode -> {
            CatNode catNode = new CatNode();
            List<CatNode> parentItem = new ArrayList<>();
            catNode.setName(parentNode.getName());
            catNode.setUrl("/getItemByCat?itemCatId="+parentNode.getId());
            nextList.forEach( next ->{
                if(parentNode.getId() == next.getParentId()){
                    CatNode nextNode = new CatNode();
                    nextNode.setName(next.getName());
                    nextNode.setUrl("/getItemByCat?itemCatId="+next.getId());
                    List<String> childItem = new ArrayList<>();
                    childList.forEach( child -> {
                        if(next.getId() == child.getParentId()){
                            childItem.add("/getItemByCat?itemCatId="+child.getId());
                        }
                    });
                    nextNode.setItem(childItem);
                    parentItem.add(nextNode);
                }
            });
            catNode.setItem(parentItem);
            catNodes.add(catNode);
        });
        return JsonUtils.toJson(catNodes);
    }
}
