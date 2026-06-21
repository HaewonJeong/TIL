/** @type {import('next').NextConfig} */
const nextConfig = {
  //  - URL 재작성 규칙을 정의하는 함수
  //  - localhost:3000/api/memos 로 작성하면 로컬 호스트 8000번으로 바꾸는 규칙 정의
  async rewrites() {
    return [{
      //개발 서버가 감지할 요청 주소. api로 시작하는 모든 요청
      source: '/api/:path*',
      //실제 요청을 전달할 대상 주소. 톰캣과 같은 주소
      destination: 'http://localhost:8080/api/:path*',
    }]
  }
};

export default nextConfig;
