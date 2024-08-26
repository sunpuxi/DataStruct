package src.stack;


import java.util.*;

/**
 * 用队列模拟栈
 * queue1:
 * queue2:
 * 入栈时：执行 queue1.push();
 * 出栈时：弹出queue1中的所有元素，然后倒序添加到queue2中，所有元素添加完毕之后，执行queue2.pop();然后弹出queue2中的所有元素倒序添加到queue1中。
 */
public class queueToStack {
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    public void push(int node){
        queue1.addLast(node);
    }

    public int pop(){
        int size1 = queue1.size();
        for (int i = 0; i < size1; i++) {
            Integer poll = queue1.removeFirst();
            list.add(poll);
        }
        for(int i=size1-1;i>=0;i--){
            queue2.offer(list.remove(i));
        }
        int res = queue2.removeFirst();
        int size2  = queue2.size();
        for (int i = 0; i < size2; i++) {
            Integer poll = queue2.removeFirst();
            list.add(poll);
        }
        for(int i=size2-1;i>=0;i--){
            queue1.addLast(list.remove(i));
        }
        return res;
    }

    public static void main(String[] args) {
        queueToStack stack = new queueToStack();
        for (int i = 0; i < 2; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 2; i++) {
            int pop = stack.pop();
            System.out.println(pop);
        }
    }
}
