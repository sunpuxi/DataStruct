package src.stack;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈的第二种实现
 * 每次向栈中存储的数据是一个数组，[x,min]。
 * x 是当前元素，min 是当前栈中的最小的元素
 */
public class minStack2 {

    private Deque<int[]> deque = new LinkedList<>();

    public minStack2() {
    }

    public void push(int x) {
        if (deque.isEmpty()){
            deque.push(new int[]{x,x});
        }else{
            deque.push(new int[]{x,Math.min(x,deque.peek()[1])});
        }
    }

    public void pop() {
        deque.poll();
    }

    public int top() {
        return deque.peek()[0];
    }

    public int getMin() {
        return deque.peek()[1];
    }
}
