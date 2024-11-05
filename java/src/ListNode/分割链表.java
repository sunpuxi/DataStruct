package src.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 分割链表 {
    public ListNode partition(ListNode head, int x) {
        // 一个集合记录所有的节点的值
        // 另一个集合记录所有小于x 的值
        // 重新遍历链表，先把第二个集合中的元素依次赋值给链表的节点
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x) res.add(cur.val);
            else list.add(cur.val);
            cur = cur.next;
        }
        if(res.size() == 0) return head;
        int index1 = 0;
        int index2 = 0;
         cur = head;
        while(cur != null &&(index1 < res.size() || index2 < list.size())){
            if(index1 < res.size()) cur.val = res.get(index1++);
            else{
                cur.val = list.get(index2++);
            }
            cur = cur.next;
        }
        return head;
    }

    public static ListNode partition2(ListNode head, int x) {
        // 解法二：遍历一次链表，将所有小于x的元素添加到链表一中
        // 将所有比x大的元素添加到链表二中，最后让链表一的末尾指针指向链表二的头节点即可
        ListNode head1 = new ListNode(0);  // 小
        ListNode head2 = new ListNode(0);  // 大
        // 需要记录的节点，head1 的末尾元素，head2的头节点
        ListNode cur1= head1;
        ListNode cur2 = head2;
        while(head != null){
            if(head.val >= x){
                cur2.next = head;
                cur2 = cur2.next;
            }else{
                cur1.next = head;
                cur1 = cur1.next;
            }
            head = head.next;
        }
        // 链接两个链表
        cur1.next = head2.next;
        cur2.next = null;
        return head1.next;
    }

    public static void main(String[] args) {
        // 1 4 3 2 5 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode listNode = partition2(head, 3);
//        while(listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        boolean cycle = isCycle(listNode);
        System.out.println(cycle);
    }

    public static boolean isCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
