package com.elephant.productitems.controller;

import com.elephant.productitems.items.compotise.ProductComposite;
import com.elephant.productitems.pojo.ProductItem;
import com.elephant.productitems.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: ProductItemController
 * @Date: 2024/09/24/16:57
 * @Description: 控制层
 */
@RestController
@RequestMapping("/product")
public class ProductItemController {
    @Autowired
    private ProductItemService productItemService;
    @PostMapping("/fetchAllItems")
    public ProductComposite fetchAllItems() {
       return productItemService.fetchAllItem();
    }
}
