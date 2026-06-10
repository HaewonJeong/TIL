package com.section03.Entity;

import com.ohgiraffers.section03.entity.EntityLifeCycle;
import com.ohgiraffers.section03.entity.Menu;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCyclesTests {

    private EntityLifeCycle lifeCycle;

    @BeforeEach
    void setUp() {
        this.lifeCycle = new EntityLifeCycle();
    }
    //비영속(new/transient) 상태. 엔티티가 만들어졌지만 영속성 컨테스트와 관계가 없는 상태

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testTransient(int menuCode){

        //when
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = lifeCycle.getManagerInstance();
        //then
        //객체 생성 시 heap 영엑에 만들어지며 주소값이 다른 객체
        assertNotEquals(foundMenu, newMenu);
        assertTrue(entityManager.contains(foundMenu));
        assertFalse(entityManager.contains(newMenu));


    }

}
