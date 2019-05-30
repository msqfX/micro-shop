package com.shop.portal.service.impl;

import com.shop.Example.ItemCatExample;
import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.CatNode;
import com.shop.pojo.ItemCat;
import com.shop.pojo.ItemCatVo;
import com.shop.portal.service.PortalService;
import com.shop.utils.JsonUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@Api(value = "API - PortalServiceImpl", description = "首页操作")
@RestController
public class PortalServiceImpl implements PortalService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${item_path}")
    private String itemPath;

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public Object getSortMenuList() {
        ItemCatExample example = new ItemCatExample();
        List<ItemCat> list = itemCatMapper.selectByExample(example);
        logger.info("get menu list success:" + list.toString());
        return list.isEmpty() ? list : convertSortNodeJson(list);

    }


    /**
     * 将分类列表转化未json数据
     *
     * @param list
     * @return
     */
    private Object convertSortNodeJson(List<ItemCat> list) {
        List<ItemCat> rootList = new ArrayList<>();
        List<ItemCat> nextList = new ArrayList<>();
        List<ItemCat> childList = new ArrayList<>();

        list.forEach(e -> {
            if (e.getIsParent()) {
                if (e.getParentId() == 0) {
                    rootList.add(e);
                } else {
                    nextList.add(e);
                }
            } else {
                childList.add(e);
            }
        });
        List<ItemCat> parentList = new ArrayList<>();
        if (rootList.size() > 14) {
            parentList = rootList.subList(0, 14);
        }
        List<CatNode> catNodes = new ArrayList<>();
        parentList.forEach(parentNode -> {
            CatNode catNode = new CatNode();
            List<CatNode> parentItem = new ArrayList<>();
            catNode.setName(parentNode.getName());
            catNode.setUrl(itemPath + "/getItemByCat?itemCatId=" + parentNode.getId());
            nextList.forEach(next -> {
                if (parentNode.getId() == next.getParentId()) {
                    CatNode nextNode = new CatNode();
                    nextNode.setName(next.getName());
                    nextNode.setUrl(itemPath + "/getItemByCat?itemCatId=" + next.getId());
                    List<ItemCatVo> childItem = new ArrayList<>();
                    childList.forEach(child -> {
                        if (next.getId() == child.getParentId()) {
                            ItemCatVo itemCatVo = new ItemCatVo();
                            itemCatVo.setName(child.getName());
                            itemCatVo.setUrl(itemPath + "/getItemByCat?itemCatId=" + child.getId());
                            childItem.add(itemCatVo);
                        }
                    });
                    nextNode.setItem(childItem);
                    parentItem.add(nextNode);
                }
            });
            catNode.setItem(parentItem);
            catNodes.add(catNode);
        });
        logger.info("menu list convert success:" + list.toString());
        return JsonUtils.toJson(catNodes);
    }
}
