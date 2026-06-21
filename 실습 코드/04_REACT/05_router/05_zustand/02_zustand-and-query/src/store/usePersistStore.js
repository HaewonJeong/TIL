import { create } from "zustand";
import { persist } from "zustand/middleware";

/*새로고침 시 상태 고정*/
export const userPersistStore = create(

    persist( //localStorage에 저장하는 기능. persist에 값 전달. localStorge는 브라우저가 제공하는 공간으로, 브라우저에 데이터 저장하게 한다. 브라우저를 껐다 켜도 데이터가 저장되어 있다. 대신 보안이 취약에서 민감한 정보는 저장하지 않는다.
        (set) => ({
            theme : "light",
            toggleTheme: () => 
                set((state) => ({theme:state.theme === "light"?"dark":"light"})) //state: 현재 상태의 snapshot
        }),
        {
            name: "theme-storage" //local storage에 저장될 key 이름
        }
    )
);