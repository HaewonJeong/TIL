import { create } from "zustand";

export const useCarStore = create( (set)=> ({
//React hook 중 하나. 
//use로 시작해, Store로 끝나게 명명

    items: [],

    addItem: (item) => set ( (state) => ({
        items: [...state.items, item] //스프레드 문법을 사용하여 리액트에 주소값 변경 알림

    })),

    removeItem: (id) => set( (state) => ( {
        items: state.items.filter( (item)=> item.id !== id)
    })),

    clearCart: () => set( {item: [] })
}))