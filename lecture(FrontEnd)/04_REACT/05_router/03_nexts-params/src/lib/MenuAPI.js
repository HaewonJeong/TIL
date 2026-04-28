import menus from "../data/menu-detail.json"

//메뉴 데이터 전체 조회
//export 쓰는 이유: 파일 안에서만 쓰는 함수가 아니라 밖에서도 import해서 사용할 함수
//export default (기본 내보내기). 파일에서 한 개만 대표로 export할 때 씀.
//menu-detail.json 를 임포트 해줌
export function getMenuList(){
    return menus; //json 파일 전체 반환
}

export function getMenuByMenuCode(menuCode){
    //true인 요소만 배열 반환
    return menus.filter(menu => menu.menuCode === parseInt(menuCode))[0];
}

//메뉴 검색 함수
export function searchMenu(searchMenuName){
    //menus라는 menu json 값에 필터
    //match() : 괄호 값 포함 여부에 따라 반환
    return menus.filter(menu => menu.menuName.match(searchMenuName))
}