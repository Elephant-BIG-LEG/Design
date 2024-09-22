package com.elephant.pojo;


import jakarta.persistence.*;

import java.io.Serializable;

/**
 * 
 * @TableName product_item
 */
@Table(name ="product_item")
public class ProductItem implements Serializable {
    /**
     * 商品编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 父类目ID
     */
    @Column(nullable = false)
    private Integer pid;


    /**
     * 商品编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 商品编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 父类目ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父类目ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProductItem other = (ProductItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }
}