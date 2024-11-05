package src.滑动窗口;

import java.util.Arrays;

public class 半径为K的平均值 {
    public static int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int index = k;
        if (index >= nums.length) return res;
        int sum = 0;
        for (int i = 0; i <= 2 * k && i < nums.length; i++) {
            sum += nums[i];
        }
        res[index++] = sum / (2 * k + 1);
        for (int i = k + 1; i < nums.length - k; i++) {
            sum += nums[i + k] - nums[i - k - 1];
            res[index++] = sum / (2 * k + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] res = getAverages(nums, k);
        for (int num : res) System.out.print(num + " ");
    }
}
