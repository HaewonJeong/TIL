import Header from "./Header";
import Navbar from "./Navbar";

//이 페이지가 모든 페이지의 공통
export default function Layout({children}){
    return (
        <>=Layout.jsx=
            <Header/>
            <Navbar/>
            {children} {/*현재 페이지 내용이 들어올 자리 */}
            {/*- Next.js는 자동으로:
                layout.js가 있으면
                그 아래 페이지(page.js)를
                {children} 위치에 넣어줍니다. */}
            =Layout.jsx=
        </>
    )
}