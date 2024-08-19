package src.Array;

import java.util.Arrays;

/**
 * leeCode 238
 * ERROR : 不能使用除法
 * 解法：画图，根据矩阵分别计算上下三角
 */
public class leeCode238 {
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        if (length == 0) return res;
        // 必须赋初始值为1，否则元素全为 0；
        res[0] = 1;
        // temp 用于第二次迭代时候用于存储中间值，不在数组上操作是因为第二次迭代会覆盖第一次迭代的值
        int temp = 1;
        // 第一次迭代计算下三角矩阵
        for(int i=1;i<length;i++){
            res[i] = res[i-1] * nums[i-1];
        }
        // 第二次迭代计算上三角矩阵并计算最终结果
        for(int i=length-2;i>=0;i--){
            temp *= nums[i+1];
            res[i] *= temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
}
