package src.Array;

/**
 * 多数元素
 *  解法：使用投票法
 */
public class LeeCode169 {
    public int findMajorityElement(int[] nums){
        int x = 0,vote = 0;
        for(int num : nums){
            if (vote == 0)x= num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2};
        LeeCode169 leeCode169 = new LeeCode169();
        int majorityElement = leeCode169.findMajorityElement(nums);
        System.out.println(majorityElement);
    }
}
