package com.elephant.productitems.repo;

import com.elephant.productitems.pojo.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: ProductItemReposity
 * @Date: 2024/09/24/17:36
 * @Description: 持久层
 */
@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem,Integer> {
}
