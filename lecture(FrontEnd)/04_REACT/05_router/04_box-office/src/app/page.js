import Image from "next/image";
import styles from "./page.module.css";
import Link from "next/link";

export default function Home() {
  return (
    <div>
      <ul>
            <li><Link href="/movie">박스오피스 영화 순위 보러가기</Link></li>
      </ul>
    </div>
  );
}
