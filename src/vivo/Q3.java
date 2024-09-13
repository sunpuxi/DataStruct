package src.vivo;

import java.util.Arrays;

/**
 * 让所有的粉丝得到的价格相同的物品
 * 价格总和为 sum
 * 则每个人必须有 sum / k
 * 5 4 1 3 2 3 2
 * 1 2 2 3 3 4 5
 */
public class Q3 {
    public static boolean canEqualDistribution(int[] prices, int k) {
        if (prices == null || prices.length==0) return false;
        // 排序
        Arrays.sort(prices);
        // 求和
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        int p = sum / k;
        if (sum % k != 0) return false;
        // 双指针
        int i = 0;
        int j = prices.length - 1;
        while(i < j){
            if (prices[i] > p || prices[j] > p) return false;
            if (prices[i] == prices[j] && prices[i] == p) return true;
            if (prices[j] == p){
                j--;
                k--;
            }else{
                if (prices[i] + prices[j] == p){
                    k--;
                    j--;
                    i++;
                }else{
                    return false;
                }
            }
        }
        return k == 0;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,4};
        boolean b = canEqualDistribution(arr, 4);
        System.out.println(b);
    }
}
