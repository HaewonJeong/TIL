import Link from "next/link"; 
//<Link>는 HTML 기본 태그가 아니고 Next가 제공하는 컴포넌트라서 직접 import 필요
import itemStyle from "./MenuItem.module.css"

export default function MenuItem ( {menu} ){
    return(
        <>
            {/* 동적 링크 */}
            <Link href={`/menu/${menu.menuCode}`}>
                <div className={itemStyle.MenuItem}>
                    <h3>메뉴 이름: {menu.menuName}</h3>
                    <h4>메뉴 가격: {menu.menuPrice}</h4>
                    <h4>카테고리: {menu.menucategoryName}</h4>
                </div>
            </Link>
        </>
    )
}