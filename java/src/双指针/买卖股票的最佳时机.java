package src.双指针;

public class 买卖股票的最佳时机 {

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     */
    public static int maxProfit(int[] prices) {
        int min = prices[0];  // 记录股票买入的最小价格
        int max = 0;  // 记录股票收益
        for(int num : prices){
            // 如果当前的股票价格小于min，更新min买入价格
            if(num < min) min = num;
            else{
                // 如果当前的股票价格大于买入价格，那么计算股票的收益
                max = Math.max(num-min,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int i = maxProfit(nums);
        System.out.println(i);
    }

}
