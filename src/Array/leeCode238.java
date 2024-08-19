package src.Array;

/**
 * leeCode 238
 * ERROR : 不能使用除法
 * 解法：画图，根据矩阵分别计算上下三角
 */
public class leeCode238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int res[] = new int[length];
        if (length == 0) return res;
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
}
