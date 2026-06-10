package com.ohgiraffers.section03.entity;

import com.ohgiraffers.section03.entity.EntityLifeCycle;
import com.ohgiraffers.section03.entity.EntityManagerGenerator;
import com.ohgiraffers.section03.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @ValueSource(ints = {4})
    void testTransient(int menuCode) {

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

//    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {4})
//    void tetManagerOtherEntityManager(int menuCode){
//
//        //when
//        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
//        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);
//        //menu1, menu2는 각각 entity Manager가 관리하고, Entity Context가 다르다.
//        //then
//        assertNotEquals(menu1, menu2);
//
//    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4})
    void tetManagedSameEntityManager(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        //when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);
        //menu1, menu2는 같은 객체를 반환 한다.
        //같은 EntityManager 안에서 동일한 PK를 조회하면 DB를 다시 조회하지 않고
        //영속성 컨텍스트에 저장된 같은 객체를 반환하는지 확인하는 코드
        //select 구문도 한 번 만

        //then
        assertEquals(menu1, menu2);

    }

    //준영속(detached): 영속성 컨텍스트에 저장되었다가 분리된 상태
    @DisplayName("준영속화 detached 테스트")
    @ParameterizedTest
    @CsvSource("11, 1000")
    void testDetachEntity(int menuCode, int menuPrice) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        //when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        //detached : 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하던 객체를 관리하지 않는 상태)로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice); //준영속 상태에서 10000원 -> 1000원 시도
        //flush : 영속성 컨텍스트의 상태를 DB에 내보낸다. commit도 하지 않는 상태이므로 rollback 가능
        //flush는 "영속성 컨텍스트가 관리하는 변경사항"만 DB에 반영한다.
        entityManager.flush();
        //then
        assertNotEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    //엔티티 준영속 -> 병합
//    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
//    @ParameterizedTest
//    @CsvSource("11, 1000")
//    void testDetachAndMerge(int menuCode, int menuPrice){
//        //given
//        EntityManager entityManager = EntityManagerGenerator.getInstance();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        //when
//        entityTransaction.begin();
//        Menu foundMenu = entityManager.find(Menu.class, menuCode);
//        //detached : 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하던 객체를 관리하지 않는 상태)로 만든다.
//        entityManager.detach(foundMenu);
//        foundMenu.setMenuPrice(menuPrice);
//
//        //병합(merge) : 엔티티가 준영속 상태인 엔티티가 다시 영속상태로 변경된 상태
//        //merge: 이 준영속 객체를 다시 관리해줘
//        entityManager.merge(foundMenu);
//        entityManager.flush();
//
//        //then
//        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
//        entityTransaction.rollback();
//    }

    //
    @DisplayName("detach후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource("11, 전복죽")
    void testDetachAndMerge(int menuCode, String menuName) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);

        //when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);

        //foundMenu에 있는 내용이 refoundMenu로 덮어쓰기 된다.
        entityManager.merge(foundMenu);

        //then
        //Test 결과 Pass
        assertEquals(menuName, refoundMenu.getMenuName());

    }

    //Note :
    // detached 된 상태로 20 -> 999 하고, merge하면?
    //DB, Persist Context에도 값이 없어 새로 insert하는 상황이 일어난다.
    //준영속 엔티티의 PK를 변경한 뒤 merge()하면, JPA는 해당 PK의 엔티티를 찾을 수 없다고 판단하여 UPDATE가 아니라 INSERT를 수행할 수 있다.

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void testClearPersistenceContext(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        //clear : 영속성 컨텍스트 초기화
        // 영속성 컨텍스트 내의 모든 엔티티를 준영속화
        entityManager.clear();

        //then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(foundMenu, expectedMenu);
        //select문이 2번 동작하고, 테스트 결과는 pass
    }

    @DisplayName("준 영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void testClosePersistenceContext(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        //close : 영속성 컨텍스트 종료.
        // EntityManager 자체 종료. 더 이상 사용 불가
        entityManager.close();

        //then
        //에러 발생
//        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
//        assertNotEquals(foundMenu, expectedMenu);

        //then
        //예외처리
        assertThrows(
                IllegalStateException.class,
                () -> entityManager.find(Menu.class, menuCode)
        );

    }

    @DisplayName("엔티티 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void testRemoveEntity(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        entityTransaction.begin();
        //remove: 엔티티를 영속성 컨텍스트 및 데이터베이스에서 삭제
        //단, 트랜잭션을 제어하지 않으면 DB에 영구 반영되지는 않음
        //커밋하는 순간 영속성 컨텍스트에서 관리하는 엔티티 객체가 데이터베이스에 반영된다.
        entityManager.remove(foundMenu);

        entityManager.flush(); //영속성 컨텍스트 내용을 DB에 동기화 하는 작업

        //then
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        //remove를 삭제하고 flush를 했기 때문에, persist context에는 6이 없어서 6번을 다시 찾으려고 해도 찾을 수 없어 null 반환
        assertNull(refoundMenu);
        //실제 DB에 반영하지 않겠다.
        entityTransaction.rollback();

    }

}
