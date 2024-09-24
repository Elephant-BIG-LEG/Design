package com.elephant.productitems.service;

import com.elephant.productitems.RedisUtils.RedisCommonProcessor;
import com.elephant.productitems.items.compotise.AbstractProductItem;
import com.elephant.productitems.items.compotise.ProductComposite;
import com.elephant.productitems.pojo.ProductItem;
import com.elephant.productitems.repo.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: ProductItemServie
 * @Date: 2024/09/24/17:38
 * @Description: 逻辑层
 */
@Service
public class ProductItemService {
    //引入Redis处理类
    @Autowired
    private RedisCommonProcessor redisCommonProcessor;
    //引入商品类目查询持久化层
    @Autowired
    private ProductItemRepository productItemRepository;
    //获取商品类目信息
    public ProductComposite fetchAllItem() {
        Object cacheItems = redisCommonProcessor.get("items");
        if(cacheItems != null){
            return (ProductComposite)cacheItems;
        }
        //执行数据库查询
        List<ProductItem> fetchDBItems = productItemRepository.findAll();
        //根据获取到的数据生成商品类目列表
        ProductComposite newComposite = generateProductItems(fetchDBItems);
        if(newComposite == null){
            throw new UnsupportedOperationException("Product Items should no bu null in DB!");
        }
        redisCommonProcessor.set("items",newComposite);
        return newComposite;
    }

    public ProductComposite generateProductItems(List<ProductItem> fetchDBItems) {
        List<ProductComposite> composites = new ArrayList<>(fetchDBItems.size());
        fetchDBItems.forEach(dbItem ->
                composites.add(ProductComposite.builder().
                        id(dbItem.getId()).
                        name(dbItem.getName()).
                        pid(dbItem.getPid()).
                        build()));
        Map<Integer,List<ProductComposite>> groupingList =
                composites.stream().collect(Collectors.groupingBy(ProductComposite::getPid));
        composites.stream().forEach(item ->{
            List<ProductComposite> list = groupingList.get(item.getId());
            item.setChild(list == null ? new ArrayList<>() : list.stream().map(x -> (AbstractProductItem)x).collect(Collectors.toList()));
        });
        ProductComposite composite = composites.size() == 0 ? null : composites.get(0);
        return composite;
    }
}
