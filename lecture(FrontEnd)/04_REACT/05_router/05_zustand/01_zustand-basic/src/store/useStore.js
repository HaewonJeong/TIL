import { create } from "zustand";

export const useStore = create( 
    (set) => (
    {
        count : 0,
        text: "",
        increase: () => set((state) => ({count: state.count + 1})),
        decrease: () => set((state) => ({count: state.count - 1})),
        //state 데이터의 스냅샷
        setText: (value) => set({text : value}),
    })
);


// import { create } from "zustand";

// export const useStore = create(function(set) {
//     return {
//         count: 0,
//         text: "",
        
//         // 1. 상태값을 기반으로 업데이트 할 때
//         increase: function() {
//             set(function(state) {
//                 return { count: state.count + 1 };
//             });
//         },
        
//         decrease: function() {
//             set(function(state) {
//                 return { count: state.count - 1 };
//             });
//         },
        
//         // 2. 외부 입력값으로 업데이트 할 때
//         setText: function(value) {
//             set({ text: value });
//         }
//     };
// });