package com.ohgiraffers.section01;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Repository //DB 커넥션을 가지는 쪽에 많이 작성
public class MemberDAO {

    private final Map<Long, MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "유관순"));
        memberMap.put(2L, new MemberDTO(2L, "홍길동"));
    }

    //전체 회원 목록 반환
    public Map<Long, MemberDTO> selectMembers(){
        return memberMap;
    }

    //id로 멤버 1명 반환
    public MemberDTO selectMember(Long id){
        MemberDTO returnMember = memberMap.get(id);

        if(returnMember == null){
            throw new RuntimeException("해당하는 id의 회원이 없습니다.");
        }

        return returnMember;
    }


}
