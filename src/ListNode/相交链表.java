package src.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回两个链表的相交的起始节点
 */
public class 相交链表 {
    /**
     *时间复杂度和空间复杂度都是 O（n）；
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null ) return null;
        Map<ListNode,Integer> map = new HashMap<>();
        while(headA!=null){
            map.put(headA,1);
            headA = headA.next;
        }
        while(headB!=null){
            if (map.containsKey(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 时间复杂度都是 O（n）；只需要便利两次最短的链表即可实现
     * 空间复杂度为 O（1）；
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB==null ) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
