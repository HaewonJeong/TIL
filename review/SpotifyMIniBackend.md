http://localhost:3000/api/musics/3 이런 식으로 주소 맨 끝에 숫자(musicId)를 붙여서 보낼 때, 자바 서블릿이 그 숫자를 쏙 가로채서 처리하는 방법

// 👑 1. 주소 뒤에 뭐가 더 붙어도 이 서블릿이 다 낚아채도록 단일슬래시+와일드카드(/*)를 붙여줘!
@WebServlet("/api/musics/*")