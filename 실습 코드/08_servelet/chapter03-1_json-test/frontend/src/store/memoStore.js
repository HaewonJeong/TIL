//frontend 폴더에 zustand 설치 : npm install zustand
//zustand store 만들고 초기 값 지정
import {createMemos, getMemos} from "@/api/memoApi";
import {create} from "zustand";

export const useMemoStore = create((set) => ({
    memos: [],
    loading: false,
    error: '',
    //서버에서 메모 목록을 가져오는 action
    fetchMemos: async () => {
        //요청 시작 전 loading은 true로, 이전 에러 메시지는 빈 문자열로 초기화
        set({loading: true, error: ''});

        try {
            // memos 빈 배열에  MemoApi의 함수 호출 통해 가져온 메모 데이터 배열을 저장함
            //받아온 배열을 zustand 상태에 저장
            const memos = await getMemos();
            //축약 표현  memos : memos
            set({memos});
        } catch (error) {
            //요청중에 문제가 생겼을 시 에러 메세지를 상태에 저장
            set({error: error.message})
        } finally {
            set({loading: false});
        }
    },
    //메모 등록 action
    addMemo: async (content) => {
        set({error: ''});
        try {
            const savedMemo = await createMemos(content);
            set((state) => ({
                //기존 배열을 스프레드 문법으로 복사해 새로운 배열에 할당한다.
                //React가 새로운 배열임을 인식할수 있게 함.
                memos: [...state.memos, savedMemo],
            }));
        } catch (error) {
            set({error: error.message});
        }
    },
}))