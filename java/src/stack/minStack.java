package src.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含 min 函数的最小栈
 */
public class minStack {

    List<Integer> list = new ArrayList<>();

    // 入栈
    public void push(int node) {
        list.add(node);
    }

    // 弹出栈顶元素
    public void pop() {
        list.remove(list.size()-1);
    }

    // 获取栈顶元素但是不弹出
    public int top() {
        return list.get(list.size()-1);
    }

    // 获取栈中的最小值
    public int min() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            min = Math.min(integer,min);
        }
        return min;
    }
}
