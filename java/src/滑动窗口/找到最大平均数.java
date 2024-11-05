package src.滑动窗口;

public class 找到最大平均数 {

    /**
     * 存在的问题：Double.MIN_VALUE 大于 -1。
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        // 滑动窗口
        double average = Double.NEGATIVE_INFINITY;  // 记录最大的平均数
        double sum = 0L;  // 记录窗口中的和
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(i<k-1) continue;
            double v = sum / k;
            average = Math.max(average, v);
            sum -= nums[i-k+1];
        }
        return average;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        double maxAverage = findMaxAverage(nums, 1);
        System.out.println(maxAverage);
    }
}
