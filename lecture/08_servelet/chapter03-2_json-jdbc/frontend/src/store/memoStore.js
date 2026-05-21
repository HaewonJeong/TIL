import {createMemos, getMemos} from "@/api/memoApi";
import {create} from "zustand";

export const useMemoStore = create((set) => ({
    memos: [],
    loading: false,
    error: '',
    // 서버에서 메모 목록을 가져오는 action
    fetchMemos: async () => {
        // 요청 시작 전 loading은 true로, 이전 에러 메시지는 빈 문자열로 초기화
        set({loading: true, error: ''});

        try {
            const memos = await getMemos();

            // 받아온 배열을 Zustand 상태에 저장
            set({memos});
        } catch (error) {
            // 요청 중 문제가 생겼을 시 에러 메시지를 상태에 저장
            set({error: error.message})
        } finally {
            set({loading: false});
        }
    },
    // 메모 등록 action
    addMemo: async (content) => {
        set({error: ''});

        try {
            const savedMemo = await createMemos(content);

            // 🔍 여기에 console.log를 넣어서 주머니를 까볼 거야!
            set((state) => {
                // ⭐ [여기 주목!] 콘솔창에 주머니 내용물(state) 출력하기!!!
                console.log("🎁 Zustand가 던져준 최신 데이터 주머니:", state);

                // 원래 하던 대로 새 메모 추가해서 리턴해주기
                return {
                    memos: [...state.memos, savedMemo],
                };
            });
        } catch (error) {
            set({error: error.message});
        }
    },
}));