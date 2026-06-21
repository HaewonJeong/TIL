package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    //생성자가 하나일 경우 생성자 주입 자동. new 키워드로 객체 생성하지 않고 바로 주입받아 사용 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //정상적으로 수행 시 commit, 실패 시 rollback.
    @Transactional
    public void registMember(MemberRegistDTO newMember) {

        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
    );

        memberRepository.save(member);

    }

    @Transactional
    public String registMemberFindName(MemberRegistDTO newMember) {
        registMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }

}
