package com.ohgiraffers.nativequery.section02.namedquery;

import jakarta.persistence.*;

// 1-1의 매핑 이름과 다른 이름을 주어야 한다.
@SqlResultSetMapping(name = "categoryCountAutoMapping2",
        entities = {@EntityResult(entityClass = Category.class)},
        columns = {@ColumnResult(name = "menu_count")}
)
@NamedNativeQueries(
        value = {
                @NamedNativeQuery(
                        name = "Category.menuCountOfCategory", //정적인 이름으로 쿼리문을 저장해놓고 사용
                        query = "SELECT a.category_code, a.category_name, a.ref_category_code," +
                " COALESCE(v.menu_count, 0) menu_count" +
                        " FROM tbl_category a" +
                        " LEFT JOIN (SELECT COUNT(*) AS menu_count, b.category_code" +
                        " FROM tbl_menu b" +
                        " GROUP BY b.category_code) v ON (a.category_code = v.category_code)" +
                " ORDER BY 1",
                resultSetMapping = "categoryCountAutoMapping2" // 위의 @SqlResultSetMapping의 name 속성과 동일하게 작성
        )
        }
        )


@Entity(name = "Section02Category")
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
