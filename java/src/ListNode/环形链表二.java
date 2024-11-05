package src.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回环形链表的第一个入环的节点
 */
public class 环形链表二 {

    /**
     * 解法一：使用 Map 存储出现过的节点，直到便利到在 Map 中出现的节点为止
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) return head;
            else map.put(head, 1);
            head = head.next;
        }
        return null;
    }

    /**
     * 解法二：双指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head,slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
