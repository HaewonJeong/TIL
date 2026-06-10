package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Entity 이름을 지정. 만약 작성하지 않으면 class 이름을 엔티티 명으로 사용한다.
@Entity(name = "entityMember")
@Table(name = "tbl_member")
public class Member {

    //PK 지정. 지정하지 않으면 have primary key~ 에러 남
    @Id
    @Column(name = "member_no")
    //자동 생성 전략을 지정. 스프링은 GenerationType.IDENTITY로 전략 가져가기.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;
    @Column(
            //컬럼 제약 조건 unique : 고유값, nullable = false : notnull 등..
            name = "member_id", unique = true,
            nullable = false, columnDefinition = "varchar(10)"
    )
    private String memberId;
    @Column(name = "member_pwd", nullable = false)
    private String memberPwd;
    @Column(name = "member_name")
    private String memberName;

    //phone 컬럼을 매핑에서 제외
    @Transient
    @Column(name = "phone")
    private String phone;

    //length 컬럼의 길이
    @Column(name = "address", length = 900)
    private String address;
    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;

    @Column(name = "member_role")
    //Enum을 String/숫자으로 다룰지 선택. 선택하지 않으면 숫자 사용한다.
    //ORDINAL(숫자) 방식은 Enum 순서 변경 시 데이터 오류가 발생할 수 있어
    // 실무에서는 주로 STRING 방식을 사용한다.
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    @Column(name = "status", columnDefinition = "char(1) default 'Y'")
    private String status;

    protected Member() {
    }

    public Member(
            String memberId, String memberPwd, String memberName,
            String phone, String address, LocalDateTime enrollDate,
            MemberRole memberRole, String status
    ) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
}


