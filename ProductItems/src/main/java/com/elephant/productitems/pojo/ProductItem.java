package com.elephant.productitems.pojo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @Author: Elephant-FZY
 * @Email: 1085062843@qq.com
 * @ClassName: ProductItem
 * @Date: 2024/09/24/17:22
 * @Description: 商品实体映射类
 */
@Data
@Entity
@Table(name="product_item")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int pid;
}
