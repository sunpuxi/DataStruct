package src.vivo;

/**
 * 0: new 1 : old
 * 1、一个小组最多三个员工
 * 2、一个小组最多一个老员工
 * 3、如果这个小组有老员工，那么这个组最多只能有两个人
 * 求最小的分组数：（1，0） + （0,0,0）
 */
public class Q1 {
    public int staffGroup(int[] staff) {
        if (staff == null || staff.length == 0) return 0;
        // 找出 1 和 0 的个数
        int numOfZero = 0;
        int numOfOne = 0;
        // 遍历
        for (int j : staff) {
            if (j == 1) numOfOne++;
            else numOfZero++;
        }
        // 如果 numOFzero == numOfOne
        if (numOfZero == numOfOne){
            return numOfZero;
        } else if (numOfZero < numOfOne) {
            // 如果新员工小于老员工
            return numOfOne;
        }else{
            // 如果新员工大于老员工
            int g1 = numOfOne; // (1,0) 组合的个数
            // 剩余的新员工
            int rest = numOfZero - numOfOne;
            // 新员工的分组
            int g2;
            if (rest % 3 == 0) g2 = rest/3;
            else{
                rest = rest / 3 + rest % 3;
                g2 = rest;
            }
            return g1+g2;
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] arr = {1,0,0,0,1};
        int i = q1.staffGroup(arr);
        System.out.println(i);
    }
}
