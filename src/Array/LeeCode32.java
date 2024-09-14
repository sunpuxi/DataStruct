package src.Array;

import java.util.Arrays;

/**
 *在排序数组中查找元素的第一个和最后一个位置
 * 5 7 7 8 8 10
 * 目标：找到这样的两个区间：[x,target],[target,y]。返回两个 target 的下标即可
 * 继续转换：找到第一个比 target 小的数的索引并找到第一个比 target 大的数的索引
 */
public class LeeCode32 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int[] res = new int[]{-1,-1};
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            int mid = (i + j) >>> 1;
            if(nums[mid] == target ){
                // 找到第一个比 target 小的数的索引
                res[0] = mid;
                j = mid-1;
            }else if (nums[mid] < target) {
                i = mid+1;
            } else if (nums[mid] > target) {
                j = mid-1;
            }else {
                j = mid-1;
            }
        }
        // 如果不存在
        if (res[0] == -1) return res;
        i = 0;
        j = nums.length-1;
        while(i <= j){
            int mid = (i + j) >>> 1;
            if(nums[mid] == target){
                res[1] = mid;
                i = mid + 1;
            }else if (nums[mid] < target) {
                i = mid+1;
            } else if (nums[mid] > target) {
                j = mid-1;
            }else {
                i = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }
}
