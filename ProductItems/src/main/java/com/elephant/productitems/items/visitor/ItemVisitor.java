package com.elephant.productitems.items.visitor;

import com.elephant.productitems.items.compotise.AbstractProductItem;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: InteVistor
 * @Date: 2024/09/24/19:24
 * @Description: 抽象访问者
 */
public interface ItemVisitor<T>{
    T visitor(AbstractProductItem abstractProductItem);
}
