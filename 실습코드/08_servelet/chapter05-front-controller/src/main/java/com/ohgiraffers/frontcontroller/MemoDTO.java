package com.ohgiraffers.frontcontroller;

//memoDTO는 서버와 주고 받을 때 메모의 모양
//getter는 자바 객체를 JSON 문자열로 내보낼 때
//setter는 JSON 데이터를 자바 객체로 받아올 때 사용한다.
public class MemoDTO {

    private int id;
    private String content;

    public MemoDTO(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public MemoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "memoDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
