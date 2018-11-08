package com.shop.controller;

import com.shop.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李正元
 * @create 2018-10-31 0:32
 * @desc
 **/
@RestController
@RequestMapping("product")
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;

    @RequestMapping("listProduct")
    public Object listProduct(Model model){
        Object listProduct = productService.listProduct();
        model.addAttribute("list", listProduct);
        return listProduct;
    }

}
