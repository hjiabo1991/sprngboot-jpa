package com.hjb.jpa.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * 实体类，使用正向工程生成对应的表
 *
 * @Entity
 */
@Entity(name = "t_pet")
@Proxy(lazy = false)
public class Pet {

    @Id // id是一个唯一值
    @GeneratedValue(strategy = GenerationType.AUTO) // 主键生成策略 auto自增
    private int id;

    @Column // 标识pname是一个普通列，使用默认值
    private String pname;

    @Column
    private String color;

    public Pet() {
    }

    public Pet(int id, String pname, String color) {
        this.id = id;
        this.pname = pname;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
