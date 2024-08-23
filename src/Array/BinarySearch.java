package src.Array;


/**
 * 二分查找
 */
public class BinarySearch {
    public static int search (int[] nums, int target) {
        if (nums.length==0) return -1;
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) >>> 1;
        while(left<=right){
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) {
                left = mid + 1;
            }else{
                right = mid-1;
            }
            mid = (left + right) >>> 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int search = search(arr, 8);
        System.out.println(search);
    }
}
