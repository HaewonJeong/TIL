package com.ohgiraffers.jsonjdbc.api;

import java.sql.Connection;
import java.util.List;
import static com.ohgiraffers.jsonjdbc.common.JDBCTemplate.*;

public class MemoService {

    private final MemoDAO memoDAO = new MemoDAO();

    public List<MemoDTO> findsAllMemos(){

        Connection con = getConnection();

        try{
            return memoDAO.selectAllMemos(con);
        }finally {
            close(con);
        }

    }

    public MemoDTO registMemo(String content) {
        Connection con = getConnection();

        try{
            return memoDAO.insertMemo(con, content);
        }finally {
            close(con);
        }
    }
}
