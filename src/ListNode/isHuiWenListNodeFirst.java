package src.ListNode;

/**
 * 不是用额外的空间
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
public class isHuiWenListNodeFirst {
    public  boolean isOrNot(ListNode head){
        // 1、反转后半部分的链表
        // 2、从前往后遍历的同事也从后往前遍历，依次比较两个元素的值即可
        if(head == null || head.next == null) return true;
        // 如果只有两个节点
        if(head.next != null && head.next.next == null) return head.next.val == head.val;
        // 其他情况
        ListNode slow = head;
        ListNode fast = head;
        // 先找到中间位置和末尾位置的节点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 开始反转后半部分,slow 后面的的链表
        ListNode right = slow.next;
        ListNode temp = right.next;
        right.next = slow;
        slow.next = null;
        slow = right;
        right = temp;
        while(right != null){
            temp = right.next;
            right.next = slow;
            slow = right;
            right = temp;
        }
        // 比较
        while(head != null && slow != null){
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
