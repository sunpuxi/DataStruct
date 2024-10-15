package src.ListNode;

/**
 * 不是用额外的空间
 * 时间复杂度：O（n）
 * 空间复杂度：O（1）
 */
public class isHuiWenListNodeFirst {
    public  boolean isOrNot(ListNode head){
        if (head == null || head.next == null) return true;
        ListNode left = head;
        ListNode right;
        ListNode slow = head;
        ListNode fast = head;
        //如果节点个数是奇数，那么fast最终指向的位置是最后一个节点
        //如果节点个数是偶数，那么fast指向的位置是最后一个节点的前一个元素，此时还需要让fast后移一位
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next!=null && fast.next.next==null) fast = fast.next;
        }
        //记录下来末尾节点
        //开始反转链表,反转 slow 之后的节点
        right = slow.next;
        ListNode tmp = right.next;
        slow.next = null;
        right.next = slow;
        slow = right;
        right = tmp;
        //循环结束之后，right为null，slow指向最后一个节点，至此后半部分的链表反转完成
        while(right != null){
            tmp = right.next;
            right.next = slow;
            slow = right;
            right = tmp;
        }
        right = slow;
        //开始比较元素的值
        while(left!=null){
            if(left.val!= right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
