package src.stack;


import java.util.Stack;

/**
 * 用两个栈实现队列
 * stack1 负责入栈
 * stack2 负责出栈
 * 入队列时：stack1.push();
 * 出队列时：一次弹出 stack1 中所有的元素，然后依次压入 stack2 中，出队列时执行 stack2.pop()即可，然后再把stack2中的元素弹出依次压入栈1中。
 */
public class stackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 1、弹出所有的元素，依次压入栈2中
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        // 2、弹出栈2顶端的元素
        int res = stack2.pop();
        // 3、依次弹出栈2的元素，压入栈1中
        int size2 = stack2.size();
        for (int i = 0; i < size2; i++) {
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return res;
    }

    public static void main(String[] args) {
        stackToQueue queue = new stackToQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }
}
