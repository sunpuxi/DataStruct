package src.Array;

/**
 *找到旋转数组中的目标值
 * 4 5 6 7 0 1 2
 */
public class SearchReverseArrayTarget {

    public int search(int[] nums, int target){
        // 分为两种情况：前半部分有序和后半部分有序
        if (nums == null || nums.length == 0) return -1;
        // 遍历
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]){
                if (nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if (target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
