package com.elephant.productitems.items.visitor;

import com.elephant.productitems.RedisUtils.RedisCommonProcessor;
import com.elephant.productitems.items.compotise.AbstractProductItem;
import com.elephant.productitems.items.compotise.ProductComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: DelItemVisitor
 * @Date: 2024/09/24/19:42
 * @Description: 具体访问者【删除的访问者】
 */
@Component
public class DelItemVisitor implements ItemVisitor<AbstractProductItem> {
    @Autowired
    private RedisCommonProcessor redisProcessor;

    /**
     * 删除商品类目
     * @param abstractProductItem
     * @return
     */
    @Override
    public AbstractProductItem visitor(AbstractProductItem abstractProductItem) {
        ProductComposite currentItem = (ProductComposite) redisProcessor.get("items");
        ProductComposite removeItem = (ProductComposite) abstractProductItem;
        //根节点不能进行删除
        if(removeItem.getId() == currentItem.getId()){
            throw new UnsupportedOperationException("Root Node could not del!");
        }
        //如果将要删除的节点的父级类目是当前节点，则直接删除
        if(removeItem.getPid() == currentItem.getId()){
            currentItem.removeProductItem(removeItem);
        }
        delChild(removeItem,currentItem);
    }

    /**
     * 通过递归找到要删除的节点的父类目，然后删除指定的子类目
     * @param removeItem
     * @param currentItem
     */
    public void delChild(ProductComposite removeItem,ProductComposite currentItem){
        for(AbstractProductItem abstractItem :currentItem.getChild()){
            ProductComposite item = (ProductComposite) abstractItem;
            if(item.getPid() == removeItem.getId()){
                currentItem.removeProductItem(item);
                break;
            }else{
                delChild(removeItem,item);
            }
        }
    }
}
