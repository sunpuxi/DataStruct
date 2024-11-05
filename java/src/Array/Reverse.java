package src.Array;

import java.util.Arrays;

/**
 * 将数组旋转90度
 */
public class Reverse {
    /**
     * 二维数组
     * @param nums 二维数组
     * @param n 长度
     * @return 返回结果
     */
    public int[][] reverse(int[][] nums,int n){
        int[][] res = new int[n][n];
        // 外层横向遍历 nums
        for (int i = 0; i < n; i++) {
            // 内层纵向填充 res
            for (int j = 0; j < n; j++) {
                res[j][i] = nums[n-i-1][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        Reverse reverse = new Reverse();
        int[][] reverse1 = reverse.reverse(nums, 2);
        for (int[] ints : reverse1) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
