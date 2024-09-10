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
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        // 遍历
        for(int k=0;k<nums.length-2;k++){
            // 如果当前元素大于0，直接退出循环，后面不存在比他小的元素，也就不会三数之和为0了。
            if(nums[k] > 0) break;
            // 去重
            if(k>0 && nums[k] == nums[k-1]) continue;
            int i = k + 1;
            int j = nums.length-1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0){
                    // sum小于0，左边的元素小了，向右移动的同时进行去重操作
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    // sum大于0，右边的元素大了，向后移动的同时去重
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    // 收集结果的同时改变两个指针的位置，并去重
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
