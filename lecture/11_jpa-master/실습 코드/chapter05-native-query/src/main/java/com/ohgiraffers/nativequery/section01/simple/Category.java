package com.ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.*;

//object[0]에는 mapping 결과가, object[1]에는 카운트가 들어 간다.
/*조회 결과
Category{categoryId=1, categoryName='식사', refCategoryCode=null}/2/
Category{categoryId=2, categoryName='음료', refCategoryCode=null}/0/
Category{categoryId=3, categoryName='디저트', refCategoryCode=null}/0/
* */
@SqlResultSetMappings(
        value = {
                /*Native SQL의 결과를 어떻게 매핑할지 정의하는 어노테이션*/
                @SqlResultSetMapping(
                        name = "categoryCountAutoMapping",
                        entities = {@EntityResult(entityClass = Category.class)},
                        columns = {@ColumnResult(name="menu_count")}
                )
        }
)
@Entity(name = "Section01Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
