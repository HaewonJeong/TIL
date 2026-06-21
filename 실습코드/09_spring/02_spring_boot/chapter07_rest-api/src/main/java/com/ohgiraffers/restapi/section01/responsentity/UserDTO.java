package com.ohgiraffers.restapi.section01.responsentity;

import lombok.*;

import java.util.Date;

@NoArgsConstructor  // 1. 기본 생성자 자동 생성
@AllArgsConstructor // 2. 모든 필드 생성자 자동 생성
@Getter             // 3. 모든 필드의 Getter 자동 생성
@Setter             // 4. 모든 필드의 Setter 자동 생성
@ToString           // 5. 예쁜 toString() 자동 오버라이딩
public class UserDTO {

    private Integer no;
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate;
    private String status;

}
