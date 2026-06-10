package com.ohgiraffers.section02.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD crud;

    @BeforeEach
    void initManager() {
        this.crud = new EntityManagerCRUD();
    }

    //메뉴 코드로 메뉴 조회 테스트 이름으로 표시 됨
    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    //하나의 테스트 메서드를 여러 번 실행할 수 있게 해줌.
    @ParameterizedTest
    //@CsvSource({"4,4", "10,10"})
    @CsvSource({"4,4", "10,10"})
    void testFindMenuByMenuCode(int menuCode, int expected) {
        //given

        //when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);

        //then
        //예상값 = 실제 조회된 메뉴 코드 비교
        assertEquals(expected, foundMenu.getMenuCode());
        System.out.println("foundMenu : " + foundMenu);
    }

    //파라미터 테스트에 사용할 테스트 데이터를 제공하는 메서드
    private static Stream<Arguments> newMenu() {
        //stream에 들어가는 요소를 of 메소드로 만듦.
        //Argument 역시 들어가는 요소를 of 메소드로 만듦
        return Stream.of(
                // testRegisStringMenu(~,~,~,~)함수 인자에 값이 들어간다.
                Arguments.of("신메뉴", 35000, 4, "Y"));
    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegisStringMenu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        //when
        Menu newMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = crud.saveAndReturnAllCount(newMenu);

        //then
        //1행을 추가하면 35개가 되는 것이 예상되는 값
        assertEquals(count, 37, count);

    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("4, 변경 된 이름")
    void testModifyMenuName(int menuCode, String menuName){

        //when
        Menu modifyMenu = crud.modifyMenuName(menuCode, menuName);

        //then
        assertEquals(menuName, modifyMenu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {38})
    void testRemoveMenu(int menuCode){
        //when
        Long count = crud.removeAndReturnAllCount(menuCode);
        //then
        assertEquals(32, count);
    }

}
