package com.ohgiraffers.section03.layeredarchitecture;

import java.util.List;

public class MemoRepository {

    List<MemoDTO> findall();

    MemoDTO save(String contnet);
}
