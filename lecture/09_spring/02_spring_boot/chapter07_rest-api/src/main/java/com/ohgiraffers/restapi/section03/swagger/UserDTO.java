package com.ohgiraffers.restapi.section03.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@NoArgsConstructor  // 1. 기본 생성자 자동 생성
@AllArgsConstructor // 2. 모든 필드 생성자 자동 생성
@Getter             // 3. 모든 필드의 Getter 자동 생성
@Setter             // 4. 모든 필드의 Setter 자동 생성
@ToString           // 5. 예쁜 toString() 자동 오버라이딩
@Schema(description = "회원정보 DTO")
public class UserDTO {

    //데이터 Model 설명을 붙이는 어 노 테 이 션
    @Schema(description = "회원번호(PK)")
    private Integer no;
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate;
    @Schema(description = "회원 활성 상태", example = "active")
    private String status;

}
