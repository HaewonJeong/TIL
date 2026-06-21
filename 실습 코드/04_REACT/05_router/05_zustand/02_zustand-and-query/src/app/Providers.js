'use client'
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { useState } from "react";

    //컴포넌트
    //앱 전체에서 데이터 공유 공급소. props로 공급하던 데이터를 provider로 리액트에서 제공해주는 query client를 provider로 제공. 반드시 client component.
    //layout을 providers로 감싸서 
    //현재 웹페이지를 그려주는 childen을 props로 받는다.
export default function Providers( {children} ) {
    const [queryClient] = useState(()=> new QueryClient({
            defaultOptions: {
                queries:{
                    staleTime: 60 * 1000, //1분동안은 다시 요청하지 않고, 캐시를 사용. 데이터는 몇 ms 동안 최신 데이터라고 믿을래? =>성능 좋아짐 
                },
            },
        })); 

    return(
        <QueryClientProvider client={queryClient}>
            {children}
        </QueryClientProvider>
    );
}