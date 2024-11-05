package src.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class DivideHuiWen {

    List<List<String>> lists = new ArrayList<>();  //结果集合
    List<String> path = new ArrayList<>();  //一个结果的元素

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return lists;
    }

    public void backTracking(String s,int index){
        // 确定终止条件
        if (index >= s.length()){
            lists.add(new ArrayList<>(path));
            return;
        }
        // 单层递归的条件
        for(int i = index; i < s.length();i++){
            if (isPalindrome(s,index,i)){
                String str = s.substring(index,i + 1);
                path.add(str);
                backTracking(s,index+1);
                path.remove(path.size()-1);
            }
        }
    }

    /**
     判断是否是回文串
     */
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
