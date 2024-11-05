package src.dynamicPlan;

import java.util.Arrays;

/**
 * 完全平方数
 */
public class WanQuanPinFangNumber {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i*i <= n;i++){
            for(int j=i*i;j<=n;j++){
                dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
