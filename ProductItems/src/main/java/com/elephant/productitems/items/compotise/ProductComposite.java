package com.elephant.productitems.items.compotise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: ProductComposite
 * @Date: 2024/09/24/17:28
 * @Description: 树枝构建类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductComposite extends AbstractProductItem{
    private int id;
    private String name;
    private int pid;
    private List<AbstractProductItem> child = new ArrayList<>();

    //增加商品
    public void addProductItem(AbstractProductItem item){
        this.child.add(item);
    }
    //移除商品
    public void removeProductItem(AbstractProductItem item){
        this.child.remove(item);
    }
    //移除相同id的商品
    public void removeProductItemById(AbstractProductItem item){
        ProductComposite removeItem = (ProductComposite) item;
        Iterator iterator = child.iterator();
        while(iterator.hasNext()){
            ProductComposite composite = (ProductComposite) iterator;
            if(composite.getId() == removeItem.getId()){
                iterator.remove();
                break;
            }
        }
    }
}
