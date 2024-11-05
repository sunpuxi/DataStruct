package src.Array;

/**
 * 找到数组中的峰值元素（极大值）,只用返回其中一个
 */
public class FindPeek {
    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right) >>> 1;
            if (nums[mid] > nums[mid+1]) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
