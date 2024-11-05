package src.backTrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 找出给定数组中，所有的三元组和等于 0 的集合。
 * 回溯解法
 * 暴力解法（O（n^3））包超时的
 */
public class SumOfThreeNumbers {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 收集结果
        List<List<Integer>> res = new ArrayList<>();
        // 遍历(k 的取值范围：[0,nums.length-3])
        for(int k = 0;k<nums.length-2;k++){
            // 剪枝
            if (nums[k] > 0) break;
            // 去重
            if (k >0 && nums[k] == nums[k-1]) continue;
            // 遍历
            int i = k + 1;
            int j = nums.length-1;
            while(i < j){
                // 计算三数之和
                int sum = nums[k] + nums[i] + nums[j];
                // 如果 sum 小了，说明左边的数太小了，向后移动
                if (sum < 0){
                    while(i<j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    // 如果 sum 大于零，说明右边的数太大了，向前移动
                    while(i<j && nums[j] == nums[--j]);
                }else{
                    // 符合条件
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    // 去重
                    while(i<j && nums[i] == nums[++i]);
                    while(i<j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
