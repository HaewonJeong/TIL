package com.ohgiraffers.section01.list.run;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        //Queue: 선입선출(FIFO) - 먼저 넣은 것이 먼저 나온다.

        //Queue는 인터페이스이므로 new 키워드로 생성 불가하다.
        //LinkedList로 구현체 생성

        Queue<String> queue = new LinkedList<>();

        //1.queue.offer : 추가
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        System.out.println(queue);

        //2.queue.peek : 첫번째 요소 조회(제거x)
        System.out.println("peek : "+queue.peek());
        System.out.println(queue);

        //3.queue.poll : 첫번째 요소 조회 및 제거
        System.out.println("poll : "+queue.poll());
        System.out.println(queue);

        //4. 빈 queue에서 poll 하는 경우 null 반환
        queue.poll();
        queue.poll();
        System.out.println(queue.poll()); //null - 빈 큐에서 poll은 null을 반환


    }
}
