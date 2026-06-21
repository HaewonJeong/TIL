package com.ohgiraffers.section03.layeredarchitecture;

import java.util.List;

public class MemoService {

    private final MemoRepository memoRepository;

    //인터페이스인 메모 레포지토리를 전달받아 생성자를 주입 받고 있음.
    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    public List<MemoDTO> selectMemos(){
        return memoRepository.findall();
    }

    public MemoDTO registMemo(String content){
        return memoRepository.save(content);
    }
}
