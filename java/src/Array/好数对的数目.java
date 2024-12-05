package src.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 好数对的数目 {

    /**
     * 枚举右边，维护左边
     */
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }else{
                int size = map.get(nums[i]).size();
                // 计算排列的个数[此处计算错误，需要考虑动态的情况]
                res += size;
                map.get(nums[i]).add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,1,3};
        int i = numIdenticalPairs(arr);
        System.out.println(i);
    }
}
