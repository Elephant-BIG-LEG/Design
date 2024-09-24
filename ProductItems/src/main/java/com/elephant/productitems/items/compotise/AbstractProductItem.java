package com.elephant.productitems.items.compotise;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: AbstractProductItem
 * @Date: 2024/09/24/17:26
 * @Description: 抽象类
 */
public class AbstractProductItem {
    //增加商品类目
    protected void addProductItem(AbstractProductItem item){
        throw new UnsupportedOperationException("Not Support child add!");
    }
    //移除商品节点
    protected void removeProductItem(AbstractProductItem item){
        throw new UnsupportedOperationException("Not Support child remove!");
    }
}
