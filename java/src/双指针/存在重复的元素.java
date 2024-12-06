package src.双指针;

import java.util.HashMap;
import java.util.Map;

public class 存在重复的元素 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i])-i) <= k) return true;
                else map.put(nums[i],i);
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,1};
        int k = 1;
        boolean b = containsNearbyDuplicate(arr, k);
        System.out.println(b);
    }
}
