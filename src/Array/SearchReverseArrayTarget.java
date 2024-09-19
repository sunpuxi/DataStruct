package src.Array;

/**
 * 找到旋转数组中的目标值
 * 4 5 6 7 0 1 2
 */
public class SearchReverseArrayTarget {

    public int search(int[] nums, int target) {
        // 分为两种情况：前半部分有序和后半部分有序
        if (nums == null || nums.length == 0) return -1;
        // 遍历
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            // 此处为什么是 <= ?
            if (nums[start] <= nums[mid]) {
                // 前半部分有序
                // 条件中没有出现 target >= nums[mid] 或者 nums[mid] >= target 的原因是 “==” 的情况是特殊条件，在前面已经返回！！！
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int divide(int m,int n){
        return (m + n) >>> 1 + 1;
    }
}
