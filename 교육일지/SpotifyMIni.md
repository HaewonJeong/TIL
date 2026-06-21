- 🛠️ VS Code 작업 공간 전환하기

현재 캡처해주신 VS Code 화면을 보면, 아직 기존에 공부하시던 Songpa-TIL 폴더가 통째로 열려있습니다. 이 상태로 코딩을 하면 파일 찾기도 헷갈리고 터미널 경로도 꼬이기 쉽습니다.

VS Code 상단 메뉴에서 파일(File) > 폴더 열기(Open Folder)를 클릭하세요.

Desktop/2026_web_developer_course/SpotifyMini 폴더를 선택해서 단독으로 열어주세요.

새 터미널(Ctrl + ~)을 열고, 경로가 ~/.../SpotifyMini로 잘 끝나는지 확인하세요.

(아직 안 하셨다면) 터미널에 npm install을 입력해 필수 패키지를 설치합니다.

git switch -c feature/본인이름을 입력해 안전한 나만의 작업 브랜치를 만듭니다.

현재 경로에서 Clone 하는 방법
- git clone https://github.com/songpa-backend/SpotifyMini.git .
- 맨 끝에 띄워쓰기 하고 마침표

깃을 만든 사람
- 리누스 토발즈(Linus Torvalds)
- 왜 만들었을까요? (재미있는 탄생 비화)
원래 리눅스 개발팀은 '비트키퍼(BitKeeper)'라는 다른 버전 관리 프로그램을 잘 쓰고 있었습니다. 그런데 비트키퍼 측에서 라이선스 정책을 바꾸면서 무료로 쓰던 리눅스 팀과 갈등이 생겼어요.

그러자 답답하고 화가 난 리누스 토발즈가 "아 진짜 짜증나네, 그냥 내가 쓸 거 새로 하나 만들고 만다!" 하고 무려 단 2주 만에 뚝딱 설계해서 코드를 짜버린 것이 바로 지금 우리가 쓰는 깃(Git)입니다.

전 세계 개발자들의 절대적인 필수품인 '리눅스'와 '깃' 두 가지를 만들어낸 걸 보면 정말 범접할 수 없는 천재이자 실행력 끝판왕이죠. 오늘 명령어 치면서 세팅하셨던 게 바로 이 사람이 화가 나서(?) 만든 시스템이랍니다!

-깃 vs 깃헙
Git : 
- 정의: 내 컴퓨터에서 소스 코드 버전을 관리해주는 소프트웨어.
- 인터넷이 없어도 동작. 
- 핀란드의 엔지니어 리누스 토르발스가 개발한 분산형 버전 관리 시스템(VCS)
- Git bash
GitHub 
- 정의: Git으로 저장한 내역을 온라인에 업로드해서 보관해주는 웹 서비스
- 인터넷이 있어야 접속 가능
- 비유 : 인스타그램, 구글 드라이브
- 마이크로소프트 산하의 Git 저장소 호스팅 서비스 및 공동 협업 플랫폼. 2008년 출시. 2018년에 MS사가 인수.

- git switch -c feature/본인이름  vs git checkout feature/본인이름 차이
```
🛠️ 1. checkout : 만능 맥가이버 칼 (과거)
원래 깃이 처음 만들어졌을 때부터 있던 아주 오래된 명령어입니다. 문제는 얘가 일을 너무 많이, 다재다능하게 했다는 겁니다.

브랜치를 바꿀 때도: git checkout 브랜치명

코드를 망쳐서 과거 상태로 복구할 때도: git checkout 파일명

하나의 명령어가 맥가이버 칼처럼 이것도 하고 저것도 하다 보니, 초보자들이 "브랜치를 바꾸려다가 실수로 코드를 날려버리는" 대참사가 자주 일어났습니다.

✂️ 2. switch : 브랜치 이동 전용 가위 (현재)
그래서 2019년에 깃을 만드는 개발자들이 결단을 내립니다. "checkout 너무 헷갈린다! 기능을 반으로 쪼개서 직관적으로 만들자!"

그 결과 checkout의 기능이 두 가지로 나뉘어 새로 탄생했습니다.

git switch: 오직 '브랜치 이동(전환)'만 담당. (직관적이고 안전함)

git restore: 오직 '파일 복구'만 담당.

🚨 핵심 주의사항: 질문하신 코드의 숨은 차이점!
질문하신 두 줄의 명령어에는 사실 아주 미묘한 차이가 하나 숨어있습니다.

git switch -c feature/본인이름

여기서 -c는 Create(만들다)의 약자입니다.

뜻: "feature/본인이름 이라는 브랜치를 새로 만들고(-c), 거기로 이동(switch)해줘!"

git checkout feature/본인이름

이 명령어에는 옵션이 없죠? 그래서 이건 단순 이동만 합니다.

만약 해당 브랜치가 없으면 에러가 납니다.

switch -c처럼 만들면서 동시에 이동하려면 checkout에서는 -b (branch) 옵션을 써야 합니다. 👉 git checkout -b feature/본인이름

💡 실전 요약 (무얼 써야 할까?)
실무에 가시면 옛날부터 개발을 해오신 시니어 분들은 손에 익어서 여전히 checkout을 많이 쓰실 겁니다.

하지만 이제 막 깃을 배우며 시작하는 입장에서는 무조건 뜻이 명확하고 안전한 최신 명령어인 switch를 사용하시는 것을 강력하게 추천합니다!
```

[npm, npx 차이]
npx
- 설명 : 내 컴퓨터에 없는 걸 인터넷에서 잠깐 빌려와서 1번 실행하고 버릴 때 쓴다. (예: 프로젝트 처음 만들 때)
예시
- $ npx create-next-app@latest 01_nexts-app : "인터넷에서 가장 최신 지식을 가진 건축가를 딱 한 번만 용역으로 불러서 기초 공사(폴더 만들기)만 시키고 돌려보내자!" 하는 마음에 1회용 실행 도구인 npx를 쓴 것.
- $ npx json-server --watch  db.json --port 3001
npm
- $ npm install: 내 프로젝트에 필요한 부품을 영구적으로 설치할 때 쓴다. (예: axios, 라이브러리 등)
- npm run: 이미 설치가 끝난 내 프로젝트 안에서, 미리 약속된 스크립트(명령어)를 작동시킬 때 쓴다. (예: dev, build, start)
- $ npm run dev : "내 프로젝트(package.json) 안에 미리 세팅해 둔 dev라는 이름의 스크립트(Next.js 화면 띄우기)를 실행해 줘!" 라는 뜻.
  - npx run dev를 친다면? : : 어제 npx는 인터넷에서 남의 도구를 1회용으로 빌려올 때 쓴다고 했었죠?
컴퓨터는 이걸 보고 "아하! 인터넷에서 run이라는 도구를 빌려와서, 우리 폴더 안에 있는 dev라는 파일을 실행하라는 뜻이구나!" 라고 착각해 버린 겁니다. 당연히 우리 폴더 안에는 dev라는 파일이 없으니 "Cannot find module (그런 모듈 못 찾겠는데?)" 하고 에러.

- db json 명령어 이해하기: $ npx json-server -watch db.json --port 3001
npm vs npx 한 줄 요약
- npm (Manager): 패키지를 내 컴퓨터나 프로젝트에 '설치하고 관리'하는 도구 (예: npm install axios)
- npx (Execute): 패키지를 설치하지 않고, 인터넷에서 잠깐 빌려와서 '딱 1번만 실행'하고 버리는 도구
- create-next-app이라는 "프로젝트 껍데기 만들어주는 프로그램"은 버전 업데이트가 엄청나게 자주 일어납니다. 만약 이걸 npm으로 내 컴퓨터에 영구 설치해 버리면, 나중에 새 프로젝트를 만들 때 구버전으로 만들어지는 불상사가 생길 수 있습니다.
그래서 npx를 써서 "내 컴퓨터에 설치하진 말고, 지금 깃허브(npm 서버)에 있는 가장 최신 버전을 딱 1번만 빌려와서 폴더만 짠! 하고 만들어줘!" 라고 명령하는 것

--watch 옵션 추가하기
watch를 붙여두면 json-server가 눈에 불을 켜고 파일을 감시(watch)하고 있다가, 파일이 수정되면 알아서 실시간으로 데이터를 새로고침

- 입력하니까 이게 나와
$ npx json-server --watch  db.json --port 3001
Need to install the following packages:
json-server@0.17.4
Ok to proceed? (y) y

💡 저 메시지가 왜 뜬 걸까요?
컴퓨터(npx)가 속으로 이렇게 생각한 겁니다.
"주인님이 json-server를 실행하라고 하시네? 내 컴퓨터를 뒤져보니까 안 깔려있네? 아하! 한 번만 빌려와서 쓰라는 뜻이구나. 지금 인터넷에서 딱 한 번 쓸 용도로 임시 다운로드할 건데, 진행해도 될까요? (y/n)"

아주 완벽하고 지극히 정상적인 반응입니다! 🎉 방금 화면에 뜬 그 메시지가 바로 아까 설명해 드렸던 npx의 진짜 정체를 보여주는 완벽한 예시입니다.

💡 저 메시지가 왜 뜬 걸까요?
컴퓨터(npx)가 속으로 이렇게 생각한 겁니다.

"주인님이 json-server를 실행하라고 하시네? 내 컴퓨터를 뒤져보니까 안 깔려있네? 아하! 한 번만 빌려와서 쓰라는 뜻이구나. 지금 인터넷에서 딱 한 번 쓸 용도로 임시 다운로드할 건데, 진행해도 될까요? (y/n)"

여기서 y (Yes)를 입력하셨으니 완벽하게 정답을 고르신 겁니다!

- 🚀 이제 화면에 무엇이 나타날까요?
조금만 기다리시면 터미널에 귀여운 이모티콘 {^_^} 과 함께 이런 식의 메시지가 뜰 겁니다.
Plaintext
  \{^_^}/ hi!
  Loading db.json
  Done
  Resources
  http://localhost:3001/posts
  http://localhost:3001/comments
  Home
  http://localhost:3001

- 서버가 잘 켜졌는지 확인하는 방법
터미널에 저런 메시지가 떴다면 가짜 백엔드 서버가 성공적으로 돌아가고 있다는 뜻입니다.
크롬 브라우저를 열고 주소창에 http://localhost:3001 이라고 쳐보세요! 

- Resourse 목록 뜻
Resources는 한마디로 "네가 프론트엔드(React/Next.js)에서 마음껏 꺼내 쓰고, 추가하고, 삭제할 수 있는 '데이터 창고의 주소(API 엔드포인트)' 목록
"db.json 파일을 살짝 열어보시면, 괄호 모양이 대략 이렇게 생겼을 겁니다.

JSON
{
  "users": [ ... ],
  "musics": [ ... ],
  "comments": [ ... ],
  "favorites": [ ... ]
}
json-server가 영리하게 db.json 파일을 싹 읽어보고, "아하! 최상위 이름표가 4개네? 그럼 내가 알아서 저 4개 이름으로 주소(URL)를 만들어 줄게!" 하고 세팅해 준 결과물이 바로 저 Resources 목록입니다.

- 저 주소들을 어떻게 쓰나요? 
어제 영화 목록 가져올 때 fetch('http://kobis.or.kr/...') 하셨던 거 기억나시죠?
이제 남의 서버를 빌려 쓸 필요 없이, 나만의 서버 주소가 생긴 겁니다!

*🎧 음악 목록을 화면에 그리고 싶을 때 (GET)*

JavaScript
// 프론트엔드 코드에서 이렇게 호출하면 음악 데이터가 쫘르륵 옵니다!
const res = await axios.get('http://localhost:3001/musics');
*✍️ 새로운 댓글을 작성했을 때 (POST)*

JavaScript
// 화면에서 댓글을 쓰고 '등록' 버튼을 누르면 이 주소로 데이터를 보냅니다.
await axios.post('http://localhost:3001/comments', { 
    content: "이 노래 찢었다..." 
});

- 이제 팀원들과 프론트엔드 화면을 만들 때, "야, 음악 데이터는 http://localhost:3001/musics 로 요청해서 쓰면 돼!" 라고 멋지게 소통하시면 됩니다.터미널은 끄지 말고 그대로 창을 내려두신 상태로 (서버가 계속 켜져 있어야 하니까요!), 본격적인 프론트엔드 코딩을 시작 하면 됩니다.

- 백엔드 관점에서의 핵심 포인트!
백엔드 수업을 듣고 계신다고 했으니 아주 중요한 포인트 하나만 짚고 넘어갈게요.

프론트엔드 입장에서는 그냥 http://localhost:3001/musics에 요청해서 데이터를 받아오면 끝입니다. 편하죠.
하지만 백엔드 개발자는 저 주소로 요청이 들어왔을 때, 실제 DB에 있는 4개의 테이블을 지지고 볶아서(JOIN 연산 등) 예쁜 JSON 형태로 포장한 뒤 프론트엔드에게 던져주는 역할을 코드로 짜야 합니다. (이걸 보통 Spring Boot나 Node.js로 만듭니다.)

지금 사용하시는 json-server는 백엔드 개발자가 그 복잡한 코드를 다 짜기 전까지, 프론트엔드 개발자가 "백엔드 완성될 때까지 손가락만 빨고 있을 순 없으니, 가짜로 테이블 4개짜리 DB인 척하는 서버 띄워놓고 화면 먼저 만들자!" 할 때 쓰는 최고의 치트키 입니다.

- 문자 엔티티 기호 뜻
&nbsp;	(공백)	Non-Breaking Space, 줄 바꿈이 되지 않는 공백 문자
&amp;	&	Ampersand(&) 문자, HTML에서 & 자체를 나타낼 때 사용
&lt;	<	Less Than(<) 문자, HTML 태그 시작 기호 < 를 나타낼 때 사용
&gt;	>	Greater Than(>) 문자, HTML 태그 끝 기호 > 를 나타낼 때 사용
&quot;	"	Quotation Mark(") 문자, 속성값의 따옴표 " 를 나타낼 때 사용

- 내 PC에서 한 작업 branch로 올리고 실습실 컴퓨터로 받아오기
```
1. 현재 상태 확인 및 저장 (터미널)
가장 먼저 작업하던 서버(npm run dev나 npm run db)는 Ctrl + C를 눌러서 잠시 꺼주세요. 그 다음 터미널에 아래 명령어를 순서대로 입력합니다.

① 변경된 파일들 담기
Bash
git add .
의미: "오늘 수정한 모든 파일(MusicApi, MusicStore, Page.js 등)을 다 가방에 넣어줘!"

② 저장 메시지 남기 (기록)
Bash
git commit -m "feat: 음악 목록 조회 기능 및 Zustand 스토어 구현"
의미: "이 가방에 '음악 조회 기능 완성함'이라는 쪽지를 붙여서 내 컴퓨터에 저장해줘!"

③ 원격 저장소(GitHub)로 보내기
Bash
git push origin 내브랜치이름
의미: "드디어 이 가방을 내 이름으로 된 온라인 창고(origin)에 올려줘!"
주의: 내브랜치이름 자리에 지금 작업 중인 브랜치명(예: feature/music 등)을 적으시면 됩니다. (잘 모르겠다면 git branch라고 쳐보세요!)

2. 내일 실습실 컴퓨터에서 할 일
내일 실습실 컴퓨터 앞에 앉으시면, "어제 내가 올린 거 가져오기"부터 시작하면 됩니다.

실습실 컴퓨터에서 프로젝트 폴더 열기 (이미 클론 되어 있다고 가정)
내 브랜치로 이동: git checkout 내브랜치이름
최신 코드 가져오기: git pull origin 내브랜치이름
라이브러리 확인: 혹시 모르니 npm install 한 번 해주기
서버 켜기: npm run dev 와 npm run db
```

- 내가 작업한 코드 합치기
1. 현재 main 작업 내용을 내 branch에 최신화 한다. : git pull origin main 
2. 내 branch를 push 해서 Pull Request를 보낸다. : git push origin feature/playlist
3. Github > Pull Request 생성 > 보여줄 코멘트를 작성하고 Create pull reqeust > 팀원이 코멘트를 남기고 [merge pull reqeust]
* 궁금한 점 : 만약 둘 다 Header.jsx를 개발했으면 어떡하죠? : 그때는 논의 합니다.

* 참고: 이렇게 하면 PR 없이 merge 된다. 실무에서는 PR를 날려 팀원 검토 하기
1. 메인 브랜치로 이동
git checkout main
2. 혹시 모르니 메인 브랜치의 최신 상태 가져오기
git pull origin main
3. 내 작업 브랜치를 메인으로 합치기 (Merge)
git merge feature/playlist
4. 합쳐진 결과를 GitHub(Main)에 반영하기
git push origin main

동료가 올린 코드 내 작업 공간으로 가져오기
1단계: 동료의 최신 코드를 내 로컬 main으로 가져오기
git checkout main          # 1. 메인 브랜치로 이동
git pull origin main       # 2. 동료가 올린 최신 코드를 다운로드
2단계: 최신 main 코드를 내 작업 브랜치로 가져오기
git checkout feature/playlist    # 1. 내 작업 브랜치로 이동
git merge main                   # 2. 최신 main 내용을 내 브랜치에 합침

내 branch에서 작업 하다가, 팀원의 main 작업 코드 받아올때
- git stash : 작업을 잠깐 치워두기 (git add, commit과 다름)

package.json 파일 설정 인스톨 명령어
- npm install - package.json

 git restore --staged db.json