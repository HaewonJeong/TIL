package com.ohgiraffers.jacksonjson;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class MemberDTO {

    private int no;
    private String main;
    private int age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private java.sql.Date enrollDate;

    public MemberDTO() {
    }

    public MemberDTO(int no, String main, int age) {
        this.no = no;
        this.main = main;
        this.age = age;
    }

    public MemberDTO(int no, String main, Date enrollDate) {
        this.no = no;
        this.main = main;
        this.enrollDate = enrollDate;
    }

    public MemberDTO(int no, String main, int age, Date enrollDate) {
        this.no = no;
        this.main = main;
        this.age = age;
        this.enrollDate = enrollDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "no=" + no +
                ", main='" + main + '\'' +
                ", age=" + age +
                '}';
    }
}
