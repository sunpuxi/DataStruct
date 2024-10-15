package src.ListNode;

/**
 * 判断链表是否有环
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        // 快慢指针，快指针移动两个单位，慢指针移动一个单位。如果相遇，那么存在环。否则不存在环。
        // 由于是单链表，所以不存在单个节点的链表构成环的情况
        if (head == null || head.next == null) return false;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
