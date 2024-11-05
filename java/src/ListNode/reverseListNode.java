package src.ListNode;

/**
 * BM1 反转链表
 * 1 -> 2 -> 3 -> 4
 *           p    c   t
 *  需要注意不要造成循环链表
 */
public class reverseListNode {

    public  ListNode ReverseList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        while(cur!=null){
            // 记录 cur 的下一个节点
            ListNode temp = cur.next;
            // 反转 pre 和 cur 之间的指针
            cur.next = pre;
            // pre 移动到 cur，cur 移动到 temp
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
