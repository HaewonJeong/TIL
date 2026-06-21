'use client' //hook을 쓰는 컴포넌트는 반드시 맨 첫줄에'use cline'선언 필요
import { usePathname } from "next/navigation";
import Link from "next/link";

export default function Navbar() {

    const pathname = usePathname(); //현재 URL의 경로를 문자열로 반환

    const isActive = (path) => pathname === path;

    const activeStyle = {
        backgorundColor : 'yellow',
        color: 'red'
    }

    return(
        <>
            <div>=Navbar.jsx=
                <ul>
                    {/* 현재 경로가 어디인지에 따라 스타일 적용 */}
                    <li><Link style={isActive('/') ? activeStyle:undefined} href="/">1메인</Link></li>
                    <li><Link style={isActive('/about') ? activeStyle:undefined} href="/about">2소개</Link></li>
                    <li><Link style={isActive('/menu') ? activeStyle:undefined} href="/menu">3메뉴</Link></li>
                    <li><Link style={isActive('/dashboard') ? activeStyle:undefined} href="/dashboard">4관리자</Link></li>
             
                </ul>=Navbar.jsx=
            </div>
        </>
    )
}