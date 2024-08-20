package src.Array;

import java.util.*;

/**
 * 全排列
 */
public class LeeCode46 {

    public static void main(String[] args) {
        LeeCode46 leeCode46 = new LeeCode46();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = leeCode46.permute(nums);
        for (List<Integer> list : permute) {
            String s = list.toString();
            System.out.println(s);
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    public void backTrack(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
            }else{
                continue;
            }
            backTrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
