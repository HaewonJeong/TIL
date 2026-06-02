package com.ohgiraffers.restapi.section03.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

//API 그룹 설정
@Tag(name="user 관련 api", description = "회원 조회, 등록, 수정, 삭제 API")
@RestController
@RequestMapping("/api/v1/swagger/response")
public class SwaggerTestController {

    private final List<UserDTO> users;

    public SwaggerTestController(){
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "판다", new Date(), "active"));
        users.add(new UserDTO(2, "user01", "pass02", "고릴라", new Date(), "active"));
        users.add(new UserDTO(3, "user01", "pass03", "원숭이", new Date(), "inactive"));
    }

    @GetMapping("/users")
        @Operation(summary = "회원 목록 조회/검색",  description = "전체 회원을 조회하거나 name, status query string으로 회원을 검색한다.")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
        })
    public ResponseEntity<ResponseMessage> findUserByConditions(
            //쿼리스트링 가져오는 어노테이션 @RequestParam
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status){

        //응답 헤더를 받는 객체
        HttpHeaders headers = new HttpHeaders();
        // Content-Type: "application/json;charset=UTF-8
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<UserDTO> foundUsers = users.stream()
                .filter(user -> {
                    //status 조건이 들어왔는데 회원의 상태가 다르면 제외
                    if(status != null && !user.getStatus().equals(status)){
                        return false;
                    }
                    //name 조건이 들어왔는데 회원 이름에 해당 글자가 포함되어 있지 않으면 제외
                    if(name != null&& !user.getName().contains(name)){
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList()); //필터링된 결과를 새로운 List로 만든다.
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("users", foundUsers);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", response);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
        @Operation(summary = "회원 번호로 조회",  description = "회원 번호를 통해 해당하는 회원 정보를 조회합니다.")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "회원 단건 조회 성공"),
                @ApiResponse(responseCode = "404", description = "회원 정보 없음")
        })
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        //응답 해더를 받는 객체
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("user", foundUser);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", response);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }


    @Operation(summary = "신규 회원 등록",  description = "신규 회원 등록")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원 등록 성공")
    })
    @PostMapping("/users")
    //ResponseEntity<Void> : 응답 body가 없음 -> .build()로 응답 완성
    public ResponseEntity<Void> regisUser(@RequestBody UserDTO newUser){

        int lastUserNo = users.get(users.size() - 1 ).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
                //HTTP에서는 새 리로스를 만들었을 때 Location header로 그 리소스를 조회 할 수 있는 위치를 알려줄 수 있다.
                .created(URI.create("/api/v1/response/users/" + newUser.getNo()))
                .build();
                //created -> 201번 성공 코드를 만듦. UIR를 헤더에 넣어준다.
                /*
                HTTP/1.1 201
                Location: /api/v1/response/users/4
                Content-Length: 0
                Date: Tue, 02 Jun 2026 02:59:42 GMT
                <Response body is empty>
                * */
    }

    @Operation(summary = "회원 정보 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "회원 수정 성공"),
            @ApiResponse(responseCode = "404", description = "회원 수정 실패")
    })
    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo,
                                           @RequestBody UserDTO modifyInfo){
            UserDTO foundUser = users.stream()
                    .filter(user -> user.getNo() == userNo)
                    .findFirst()
                    .get();
            foundUser.setId(modifyInfo.getId());
            foundUser.setId(modifyInfo.getPwd());
            foundUser.setId(modifyInfo.getName());

            return ResponseEntity
                    .noContent() //204 No Content
                    .build();
            /*
            ResponseEntity.noContent()가 실행되면 HTTP 상태 코드는 204 No Content가 됩니다.
            204번 상태 코드: 클라이언트(프론트엔드)의 요청을 서버가 성공적으로 처리(200번대)했지만, 응답 본문(Response Body)에 담아서 보낼 콘텐츠(Content)는
            없다(No)는 것을 명시적으로 알려주는 성공 코드입니다.
            뒤에 .build()를 붙임으로써 "바디에 아무 데이터도 넣지 않고 204 상태 코드로만 응답 상자를 완성하겠다"고 테이프를 치는 것
            * */
    }

    @Operation(summary = "회원 정보 삭제")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "회원 정보 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "회원 정보 없음")
    })
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo){

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()
                .build();
    }
}
