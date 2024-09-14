package src.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 同一个元素可以被无限次数选取
 */
public class LeeCode39 {

    List<List<Integer>> res = new ArrayList<>();  // result
    List<Integer> path = new ArrayList<>();  // single result

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1: sort
        Arrays.sort(candidates);
        // 去重
        backTrack(0,0,candidates,target);
        return res;
    }

    public void backTrack(int startIndex,int sum,int[] candidates,int target){
        // 终止条件
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        // 从 startIndex 开始遍历
        for(int i = startIndex;i<candidates.length;i++){
            // 剪枝
            if (sum + candidates[i] > target) return;
            // 添加元素
            path.add(candidates[i]);
            // 回溯
            backTrack(i,sum + candidates[i],candidates,target);
            // 移除最后一个元素
            path.remove(path.size()-1);
        }
    }
}
