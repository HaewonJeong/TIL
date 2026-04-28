import Link from "next/link";//link 선택 시 자동 import

/*루트 페이지. 3000번으로 라우팅 될 떄 뜨는  화면*/
/*export default : 내보내기 위해 function 앞에 작성 */
export default function Home(){
  return (
    <>=app/menu/page.js=
      <h1>메뉴</h1>
      <nav>
        {/*태그는 외부 사이트에서 사용.*/}
        <Link href="/">Home</Link>
        <Link href="/about">소개</Link>
        <Link href="/menu">메뉴</Link>
      </nav>=app/menu/page.js=
    </>
  )
}