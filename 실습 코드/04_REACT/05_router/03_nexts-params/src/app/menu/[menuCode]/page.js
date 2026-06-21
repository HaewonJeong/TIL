'use client';
import { useParams } from "next/navigation";
import { useState, useEffect } from "react";
import { getMenuByMenuCode } from "@/lib/MenuAPI";
// [menuCode] 폴더
// /menu/3 -> app/menu/[menuCode]/page.js

export default function MenuDetail(){

    const {menuCode} = useParams(); //동적인 값을 읽어온다.
    //menuCdoe:'5', menu/5
    console.log(menuCode);
    
    const [menu, setMenu] = useState();

    useEffect( ()=> {
        setMenu(getMenuByMenuCode(menuCode))
    },[])

    return(
        menu && 
        <>
            <h1>={menu.menuName} 상세페이지!=</h1>
            <h3>메뉴 가격: {menu.menuPrice}</h3>
            <h3>메뉴 종류: {menu.categoryName}</h3>
            <h3>메뉴 설명: {menu.detail.description}</h3>
            <img src={menu.detail.image} style={{maxWidth:500}} />
        </>
    )
}