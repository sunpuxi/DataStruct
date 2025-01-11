package src.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ^ 运算符是异或，1 << n 是计算 2 的 n 次幂的高效计算方式
 */
public class 将链表数字转换为十进制数字 {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        // 转换为十进制数字
        int sum = 0;
        for(int i=list.size()-1;i>=0;i--){
            sum += list.get(i)*(1 << (list.size()-i-1));
        }
        return sum;
    }
}
