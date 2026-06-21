package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section06Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    public Integer refCategoryCode;
    @OneToMany(mappedBy = "category") //FK를 적어준다.
    private List<Menu> menuList;


}
