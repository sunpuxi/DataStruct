package src.dynamicPlan;

/**
 * 打家劫舍简单版
 */
public class robberyOne {

    //  动态规划
    // 1、确定 dp 数组的下标以及值的含义，dp[i] 表示抢劫下标 i 之内的最大价值
    public int solution(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];  // 初始化
        if (nums.length == 1) return dp[0];
        dp[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            // 迭代条件
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
