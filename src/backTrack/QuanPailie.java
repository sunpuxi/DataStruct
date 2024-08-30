package src.backTrack;

import java.util.ArrayList;

/**
 * 给定数组的全排列
 */
public class QuanPailie {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    boolean[] used;

    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        int len = num.length;
        used = new boolean[len];
        backTrack(num);
        return res;
    }

    public void backTrack(int[] num){
        // 终止条件
        if (path.size() == num.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历
        for(int i=0;i< num.length;i++){
            // 判断当前元素是否已经被使用过
            if (used[i] == false){
                path.add(num[i]);
                used[i] = true;
            }else continue;
            backTrack(num);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
