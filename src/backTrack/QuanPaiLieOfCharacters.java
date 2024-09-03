package src.backTrack;

import java.util.*;

/**
 * 字符的全排列，可能包含重复字符
 */
public class QuanPaiLieOfCharacters {
    ArrayList<String> res = new ArrayList<>();  // 结果
    ArrayList<Character> path = new ArrayList<>();  // 单次结果收集
    Set<String> set = new HashSet<>();  // 去重
    boolean[] used;

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        used = new boolean[chars.length];
        backTrack(chars);
        res.addAll(set);
        return res;
    }

    public void backTrack(char[] chars) {
        // 终止条件
        if (path.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            set.add(sb.toString());
            return;
        }
        // 遍历其他元素
        for (int i = 0; i < chars.length; i++) {
            // 判断该元素是否已经使用过
            if (used[i]) {
                continue;
            }
            path.add(chars[i]);
            used[i] = true;
            backTrack(chars);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
