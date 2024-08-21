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

    List<List<Integer>> res = new ArrayList<>();  // 最终结果
    LinkedList<Integer> path = new LinkedList<>();  // 单次结果收集
    boolean[] used;  // 标记元素是否已经使用

    public List<List<Integer>> permute(int[] nums) {
        // 初始化 used 数组
        used = new boolean[nums.length];
        // 回溯
        backTrack(nums);
        // 返回
        return res;
    }

    /**
     * 回溯
     * @param nums 数组
     */
    public void backTrack(int[] nums){
        // 终止条件,手机结果，并回溯
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 回溯
        for(int i=0;i< nums.length;i++){
            // 判断当前元素是否已经使用过
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
            }else{
                continue;
            }
            backTrack(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
