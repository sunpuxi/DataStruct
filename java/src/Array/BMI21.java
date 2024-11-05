package src.Array;

/**
 * 给定一个非降序的数组，找出其中的最小值，时间复杂度O(logN)
 * 思路分析：最小值只会出现在数组的开头或者两个非降序数组交界处
 */
public class BMI21 {
    public static int minNumberInRotateArray(int[] nums) {
        // 从后往前找第一个 index1
        int i = nums.length - 1;
        while (i > 0 && nums[i] > nums[i - 1]) {
            i--;
        }
        return Math.min(nums[0], nums[i]);
    }

    /**
     * 改进版本
     *
     * @param nums 数组
     * @return 最小值
     */
    public int minNumberInRotateArray2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (nums[m] > nums[j]) i = m + 1;
            else if (nums[m] < nums[j]) j = m;
            else j--;
        }
        return nums[j];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int i = minNumberInRotateArray(arr);
        System.out.println(i);
    }
}
