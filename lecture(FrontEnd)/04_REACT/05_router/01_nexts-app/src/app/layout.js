import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

/*메타 데이터 설명. 자동 head 태그 안쪽에 추가해줌 */
export const metadata = {
  title: "My first NextJs App",
  description: "I am a Web developer",
};
/* childeren : 현재 위치하는 URL을 그려줌*/
export default function RootLayout({ children }) {
  return (
    <html lang="en" className={`${geistSans.variable} ${geistMono.variable}`}>
      <body>{children}</body>
    </html>
  );
}
