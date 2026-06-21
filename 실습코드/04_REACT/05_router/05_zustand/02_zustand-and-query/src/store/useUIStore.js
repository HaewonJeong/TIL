import { create } from "zustand";

export const useUIStore = create(function(set){
    return{
        isModalOpen: false,
        isSidebarOpen: false,

        openModal: () => set ( {isModalOpen: true} ),
        closeModal: () => set ( {isModalOpen: false} ),

        toggleSidebar: () => set( (state) => ( {isSidebarOpen: !state.isSidebarOpen}))
    };
});
//set: store안의 상태 관리 함수