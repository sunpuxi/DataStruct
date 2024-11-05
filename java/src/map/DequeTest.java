package src.map;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 测试双端队列的 API
 * 结论：Deque 下面的 offer 和 poll 方法搭配是队列的特性，push 和 poll 搭配是栈的特性
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
