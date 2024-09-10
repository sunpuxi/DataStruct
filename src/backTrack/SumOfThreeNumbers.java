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
        // 结果集合
        List<List<Integer>> res = new ArrayList<>();
        // 遍历
        for (int k = 0; k < nums.length - 2; k++) {
            // 最小的元素都大于0，那么三数之和必定不可能为0，后面也没有必要继续遍历了
            if (nums[k] > 0) break;
            // 如果 k 大于0,并且第k个元素等于他的前一个元素，那么进行去重操作
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
