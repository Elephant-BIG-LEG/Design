package com.elephant.productitems.items.visitor;

import com.elephant.productitems.RedisUtils.RedisCommonProcessor;
import com.elephant.productitems.items.compotise.AbstractProductItem;
import com.elephant.productitems.items.compotise.ProductComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: AddItemVisitor
 * @Date: 2024/09/24/19:26
 * @Description: 具体访问者【添加的访问者】
 */
@Component
public class AddItemVisitor implements ItemVisitor<AbstractProductItem> {
    @Autowired
    private RedisCommonProcessor redisProcessor;

    /**
     * 添加新商品类目，根据pid进行分类
     * @param abstractProductItem
     * @return
     */
    @Override
    public AbstractProductItem visitor(AbstractProductItem abstractProductItem) {
        //从redis中获取当前数据
        ProductComposite currentItem = (ProductComposite) redisProcessor.get("items");
        //需要新增的商品
        ProductComposite addItem = (ProductComposite) abstractProductItem;
        //如果当前更新商品的父级id为当前商品
        if(addItem.getPid() == currentItem.getId()){
            currentItem.addProductItem(addItem);
            //还是要返回根节点，为了能形成树形结构
            return currentItem;
        }
        //通过addChild方法进行添加
        addChild(addItem,currentItem);
        return currentItem;
    }

    /**
     * 寻找新增类目的位置 使用递归
     * @param addItem
     * @param currentItem
     */
    public void addChild(ProductComposite addItem,ProductComposite currentItem){
        for(AbstractProductItem abstractProductItem : currentItem.getChild()){
            ProductComposite item = (ProductComposite) abstractProductItem;
            if(item.getId() == addItem.getPid()){
                currentItem.addProductItem(addItem);
                break;
            }else{
                addChild(addItem,item);
            }
        }
    }
}
