package src.Array;

import java.util.Arrays;

public class 长度为k的子数组能量值 {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int index = 0;
        boolean pre = false;  // 记录前一个序列是否为连续上升的
        for(int i=0;i<=nums.length-k;i++){
            if(isOrNot(nums,i,i+k-1,pre)){
                pre = true;
                res[index++] = nums[i+k-1];
            }else{
                res[index++] = -1;
                pre = false;
            }
        }
        return res;
    }

    /**
     * 主要的操作是在这个方法，时间复杂度最坏为O（n*k）
     * @param nums
     * @param left
     * @param right
     * @param pre
     * @return
     */
    public boolean isOrNot(int[] nums,int left,int right,boolean pre){
        if(pre){
            return nums[right] == nums[left]+right-left;
        }
        while(left < right){
            if(nums[left] != nums[left+1]-1) return false;
            left++;
        }
        return true;
    }

    public int[] resultsArray2(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Arrays.fill(res,-1);
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            cnt = i== 0 || nums[i] == nums[i-1] + 1 ? cnt+1 : 1;
            if (cnt >= k) res[i-k+1] = nums[i];
        }
        return res;
    }
}
