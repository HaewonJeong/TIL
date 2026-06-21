import { create } from "zustand";

export const useUserStore = create( (set) => ({
    user: null,
    loading: false,
    
    //Three states
    login: (userData) => set( {user: userData}),
    logout: () => set( {user:null} ),
    setUser: (user) => set({user}),

    //비동기 액션 추가
    fetchUser: async() => {
        set({loading: true}); //통신 시작 시 로딩 true
        
        try{
            const res = await fetch('https://jsonplaceholder.typicode.com/users/3');
            //fetch시 Promise 객체 반환.
            //작업이 완료 된 뒤 값을 받아오고 싶을때는 fetch 앞에는 await, fetchUser에는 async
            const data = await res.json();

            set( {user: data} ); //데이터 저장

        }catch (error){
            console.error(error);
        }finally{
            set({loading: false})
        }     
    }
}))