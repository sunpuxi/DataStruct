package src.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 */
public class LeeCode77 {

    List<List<Integer>> res = new ArrayList<>();  //存放结果的集合
    LinkedList<Integer> path = new LinkedList<>();  //存放每一个元素的集合

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1);
        return res;
    }

    public void backTrack(int n,int k,int startIndex){
        // 终止条件
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        // 回溯(注意此处的 i<= n)
        for(int i = startIndex;i<=n;i++){
            path.add(i);
            backTrack(n,k,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LeeCode77 leeCode77 = new LeeCode77();
        List<List<Integer>> combine = leeCode77.combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
