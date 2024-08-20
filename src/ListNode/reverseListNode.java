package src.ListNode;

import java.util.List;

/**
 * BM1 反转链表
 * 1 -> 2 -> 3 -> 4
 *           p    c   t
 *  需要注意不要造成循环链表
 */
public class reverseListNode {
    public static ListNode ReverseList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre=head;
        ListNode cur =pre.next;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            if (pre == head) pre.next = null;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = ReverseList(head);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
