package src.Array;

/**
 * 枚举右断点收缩左端点
 */
public class 长度最小的子数组和 {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口：
        // 初始化窗口：窗口中的元素值刚好大于等于target的时候。
        // 记录下此时的窗口的大小
        // 然后，左边的指针向右移动
        // 依次比较找出最小窗口尺寸即可
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum >= target){
                res = Math.min(res,i-left+1);
                sum -= nums[left++];
            }
        }
        return res < Integer.MAX_VALUE ? res : 0;
    }
}
