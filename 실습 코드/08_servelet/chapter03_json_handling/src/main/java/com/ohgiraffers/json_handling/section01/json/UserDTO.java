package com.ohgiraffers.json_handling.section01.json;
import jakarta.servlet.annotation.WebServlet;

public class UserDTO  {

    private String id;
    private String nickname;
    private int age;

    //기본 생성자 (Jackson 라이브러리가 역직렬화할 때 필수!)
    //없으면 에러난다.
    //Json 텍스트 개체가 넘어왔을때 UserDTO으로 작동 변화.
    //-외부에서 날아온 납작한 JSON 텍스트(택배 상자)를 받아서, 다시 자바가 읽고 쓸 수 있는 듬직한 UserDTO 객체(로봇)로 조립해내는 과정
    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // 콘솔창에 주소값 대신 예쁘게 데이터 찍히라고 만든 toString
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }


}
