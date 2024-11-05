package src.Array;

/**
 * 双指针
 */
public class 两数之和输入一个有序数组 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            // 如果sum大于target，那么说明right索引位置的数字太大了，应该往左移
            if(sum > target){
                while(nums[left] + nums[right] > target) right--;
            }else if(sum < target){
                while(nums[left] + nums[right] < target) left++;
            }else{
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }
}
