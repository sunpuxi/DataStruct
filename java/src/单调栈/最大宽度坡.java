package src.单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * i ＜ j，nums【i】 ≤ nums【j】；实际的值不需要关注，将题目转换为找出满足条件的最大的 j 和最小的 i。
 * 不再是常规的单调栈的操作
 * 解题办法：1、找出最长的递减序列  2、从后开始往前找结果
 * 问题：为什么这样是可行的？
 */
public class 最大宽度坡 {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        // 找到以nums[0]为起始元素的，最长的递减序列（非连续）。
        for(int i=1;i<len;i++){
            // 栈顶的元素大于当前元素，将当前元素的下标入栈
            if(nums[deque.peek()] >= nums[i]) deque.push(i);
        }
        // 从后往前遍历，依次比较坡的宽度。
        for(int i=len-1;i>=0;i--){
            while(!deque.isEmpty() && nums[deque.peek()] <= nums[i]) max = Math.max(i-deque.pop(),max);
        }
        return max;
    }
}
