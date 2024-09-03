package src.ListNode;

/**
 * 在指定区间内反转链表
 */
public class ReverseListNodeFromMToN {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;  // 记录第 m-1 个节点
        ListNode left;  // 记录第 m 个节点
        ListNode pre = dummy;
        ListNode cur = pre.next;
        int k = n - m;
        // 找到第 m 个节点以及di m-1 个节点，pre 为第 m 个节点,
        while (m > 0) {
            if (m == 1) preNode = pre;
            pre = pre.next;
            cur = cur.next;
            m--;
        }
        left = pre;
        // 开始反转
        while(k > 0 && cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            k--;
        }
        // 特殊处理
        preNode.next = pre;
        left.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
