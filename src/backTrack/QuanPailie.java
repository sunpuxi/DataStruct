package src.backTrack;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给定数组的全排列
 * (如果数组中有重复元素,如何对最终的排列结果去重,添加进一个 Set 中？)
 */
public class QuanPailie {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    Set<ArrayList<Integer>> set = new LinkedHashSet<>();
    boolean[] used;

    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        int len = num.length;
        used = new boolean[len];
        backTrack(num);
        res.addAll(set);
        return res;
    }

    public void backTrack(int[] num){
        // 终止条件
        if (path.size() == num.length){
             set.add(new ArrayList<>(path));
            // res.add(new ArrayList<>(path));
            return;
        }
        // 遍历
        for(int i=0;i< num.length;i++){
            // 判断当前元素是否已经被使用过
            if (!used[i]){
                path.add(num[i]);
                used[i] = true;
            }else continue;
            backTrack(num);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
