package com.springbootjpa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity  // 说明此类是实体类
@Table(name = "CATEGORY")  // 类名对应的表名
public class Category implements Serializable {
    private static final long serialVersionUID = 2251032296464034855L;

    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.AUTO) // 自动增长
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
