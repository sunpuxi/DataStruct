package src.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间:O(N)
 * 空间:O(logN)
 */
public class 找出临界点之间的最大和最小距离 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        // 特殊情况
        if(null == pre || null == cur) return new int[]{-1,-1};
        // 找到每一个临界点创建对应的元组 (x,n) x--节点值 n--节点的相对位置
        List<Integer> nodeList = new ArrayList<>();
        int count = 0;  // 记录相对位置
        while(cur.next != null){
            // 记录临界值
            if(cur.val > cur.next.val && cur.val > pre.val) nodeList.add(count);
            else if(cur.val < cur.next.val && cur.val < pre.val) nodeList.add(count);
            cur=cur.next;
            pre=pre.next;
            count++;
        }
        // 判断是否存在两个临界点
        if(nodeList.size() < 2) return new int[]{-1,-1};
        // 遍历集合找到最小距离
        int min=Integer.MAX_VALUE;
        for(int i=0,j=i+1;i<nodeList.size()-1;i++,j++){
            min = Math.min(nodeList.get(j)-nodeList.get(i),min);
        }
        return new int[]{min,nodeList.get(nodeList.size()-1)-nodeList.get(0)};
    }
}
