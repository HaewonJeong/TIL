package com.ohgiraffers.jsonjdbc.api;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.jsonjdbc.common.JDBCTemplate.close;

public class MemoDAO {

    //1. selectAllMemos (메모 목록 싹 긁어오기)
    public List<MemoDTO> selectAllMemos(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<MemoDTO> memos = new ArrayList<>();

        String query = "  SELECT memo_id, content, created_at FROM tbl_memo  ORDER BY memo_id DESC   ";

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                memos.add(new MemoDTO(
                        rset.getInt("memo_id"),
                        rset.getString("content"),
                        formatTimestamp(rset.getTimestamp("created_at"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return memos;
    }

    //2. insertMemo (새 메모 등록하기)
    public MemoDTO insertMemo(Connection con, String content) {
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        String query = "INSERT INTO tbl_memo(content) VALUES (?)";

        //generatedKeys 를 통해 autoIncremented된 ID를 받을 수 있게 하는 옵션
        //INSERT 실행 후 자동 생성된 PK를 읽을 수 있게 해줌.
        try {
            pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, content);
            pstmt.executeUpdate();

            //db가 자동으로 만든 key 목록을 ResultSet 형태로 반환 받을 수 있다.
            //MySQL아, 방금 INSERT 하면서 너가 자동으로 생성한 번호(Generated Keys) 목록 장부 좀 이리 줘봐!" 하고 장부를 받아오는 거야.
            //이 장부의 이름이 바로 generatedKeys라는 ResultSet (디비 전용 데이터 상자) 란다!
            generatedKeys = pstmt.getGeneratedKeys();


            //디비가 준 번호 장부의 첫 번째 줄을 한번 읽어볼까? (next()) 어라, 진짜로 새로 발급된 번호가 적혀있네!" 하고 데이터가 있는지 확인하는 거야.
            if(generatedKeys.next()){
                //장부의 첫 번째 칸(1) 에 적힌 숫자를 가져와서 id라는 변수에 저장하자!
                int id = generatedKeys.getInt(1);
                //방 번호가 7번인 걸 알아냈으니, 아까 밑에 만들어 둔 selectMemoById(con, 7) 메서드한테 일을 시키자!
                return selectMemoById(con, id); //1. 성공하면 MemoDTO 던짐
            }

            throw new SQLException("생성된 memo_id를 읽을 수 없다.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e); //2. 실패하면 에러 반환
        }finally {
            close(generatedKeys);
            close(pstmt);
        }
    }

    //3. 메모 선택
    private MemoDTO selectMemoById(Connection con, int id){
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = " SELECT memo_id, content, created_at  FROM tbl_memo WHERE memo_id = ? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();

            if(rset.next()){
                return new MemoDTO(
                  rset.getInt("memo_id"),
                  rset.getString("content"),
                  formatTimestamp(rset.getTimestamp("created_at"))
                );
            }
            throw new SQLException("등록된 메모를 조회할 수 없습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
    }


    private String formatTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        return timestamp.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
