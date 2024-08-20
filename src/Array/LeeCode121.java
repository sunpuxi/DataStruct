package src.Array;


/**
 * 买卖股票的最佳时机
 * 贪心
 */
public class LeeCode121 {
    public static int maxProfit(int[] prices){
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int num : prices){
            cost = Math.min(cost,num);  // 买入的花费
            profit = Math.max(num-cost,profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
