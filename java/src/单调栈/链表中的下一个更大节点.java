package src.单调栈;

import src.ListNode.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 和普常规的单调栈的区别：常规的单调栈中存储的是对应元素的下标。而链表不能通过下标进行访问。
 * 所以将这个问题转换为常规的单调栈问题的方法是将链表中的元素转移到数组中。
 * 单调栈中不适合存储实际元素的值，因为如果题目没有限制元素是否可以重复则会出现问题。
 */
public class 链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head;
        int len=0;
        List<Integer> list = new ArrayList<>();
        while(curr != null){
            len++;
            list.add(curr.val);
            curr = curr.next;
        }
        int[] ans = new int[len];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<len;i++){
            int val = list.get(i);
            while(!deque.isEmpty() && val > list.get(deque.peek())){
                int pop = deque.pop();
                ans[pop] = val;
            }
            deque.push(i);
        }
        return ans;
    }
}
