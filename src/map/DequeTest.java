package src.map;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 测试双端队列的 API
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque  = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

        while(!deque.isEmpty()){
            Integer poll = deque.poll();
            System.out.print(poll+" ");
        }

        System.out.println();
        System.out.println("**********************");

        deque.offer(1);
        deque.offer(2);
        deque.offer(3);

        while(!deque.isEmpty()){
            Integer poll = deque.poll();
            System.out.print(poll+" ");
        }
    }
}
