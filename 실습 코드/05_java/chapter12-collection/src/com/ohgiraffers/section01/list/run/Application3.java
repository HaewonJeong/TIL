package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        /*
        * LinkedList : 각 요소가 앞뒤 요소를 '링크'로 연결
        * 추가/삭제 : 링크만 수정하면 되므로 중간 삽입/삭제가 빠름
        * 조회: 처음부터 순서대로 찾아야 하므로 느림
        * */
        List<String> linkedList = new LinkedList<>();

        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("grape");

        System.out.println(linkedList);

        System.out.println(linkedList.get(0));

        //index 위치의 값을 삭제
        //linkedlist는 쉽게 삽입 삭제 가능
        linkedList.remove(1);
        System.out.println(linkedList);

        linkedList.clear();
        System.out.println(linkedList.isEmpty());

        /*
        * LinkedList 시간복잡도
        * 조회 : O(n) 다음 노드->다음 노드를 찾아기 때문. index 조회가 많을때는 ArrayList가 낫다.
        * 맨 앞 삽입/삭제 : O(1)
        * 중간 삽입/삭제 : O(n)
        * 맨 뒤 삽입/삭제 : O(1)
        *
        * ArrayList 시간 복잡도
        * 조회 : O(1)
        * 맨 앞 삽입/삭제 : O(n)
        * 중간 삽입/삭제 : O(n)
        * 맨 뒤 삽입/삭제 : O(1)
        * */

    }
}
