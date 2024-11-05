package src.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 删除链表中的重复节点 {
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode preNode = head;
        ListNode curr = head.next;
        while(curr != null){
            if(!set.contains(curr.val)){
                // 如果 set 中不存在 curr 的值，那么直接添加即可，然后继续遍历
                set.add(curr.val);
                curr = curr.next;
                preNode = preNode.next;
            }else{
                // 此时 set 中存在curr的值，需要移除 curr。
                ListNode tempNode = curr.next;
                preNode.next = tempNode;
                curr.next = null;
                curr = tempNode;
                // 此处不用移动 preNode，继续循环，判断 curr 是否重复即可。
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        ListNode res = removeDuplicateNodes(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
