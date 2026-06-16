package com.ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public class NativeQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //결과 타입을 정의한 native query 테스트
    public Menu nativeQueryByResultType(int menuCode) {
        //네이티브 쿼리로 필드 작성
        //Native Query 수행 결과를 엔티티에 매핑시키려면 모든 컬럼이 조회 되어야만 매핑 가능하다.
        /*createNativeQuery(sql, Menu.class)는 조회 결과를 Menu 엔티티에 매핑해야 하므로 Menu 엔티티의 모든 컬럼이 SELECT 절에 포함되어 있어야 한다.
        일부 컬럼만 조회할 경우 엔티티 매핑 대신 Object[] 또는 DTO를 사용해야 한다.*/
        String query = "SELECT menu_code, menu_name, menu_price, category_code, orderable_status "
                + "FROM tbl_menu WHERE menu_code = ?";

        Query nativeQuery = entityManager.createNativeQuery(query, Menu.class).setParameter(1, menuCode)
                .setParameter(1, menuCode);

        //Menu로 다운 캐스팅 후 반환
        // Query 객체의 메서드 반환 타입이 Object 이기때문
        return (Menu) nativeQuery.getSingleResult();

    }
    //결과 타입을 정의 할 수 없는 Native Query 테스트
    public List<Object[]> nativeQueryByNoResultType() {
        String query = "SELECT menu_name, menu_price FROM tbl_menu";
        Query nativeQuery = entityManager.createNativeQuery(query);

        return nativeQuery.getResultList();

    }

    //자동 결과 매핑
    public List<Object[]> nativeQueryByAutoMapping() {
        String query
                = "SELECT a.category_code, a.category_name, a.ref_category_code," +
                " COALESCE(v.menu_count, 0) menu_count" + //메뉴 갯수 없으면 Null이 아닌 0으로 표시
                " FROM tbl_category a" +
                " LEFT JOIN (SELECT COUNT(*) AS menu_count, b.category_code" + //서브쿼리
                " FROM tbl_menu b" +
                " GROUP BY b.category_code) v ON (a.category_code = v.category_code)" +
                " ORDER BY 1";
        Query nativeQuery
                = entityManager.createNativeQuery(query, "categoryCountAutoMapping");
        return nativeQuery.getResultList();
    }

}
