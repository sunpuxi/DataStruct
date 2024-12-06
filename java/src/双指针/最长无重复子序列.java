package src.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出字符串中最长的无重复的子序列
 */
public class 最长无重复子序列 {
    public static void main(String[] args) {
        String str = "abcdabccbba";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    /**
     * 将问题转化为：找出字符串中所有的重复的字符的间距，然后在其中找出最大值。
     */
    public static int lengthOfLongestSubstring(String str) {
        Map<Character,Integer> map = new HashMap<>();
        // left 为什么要取 -1？ 原因：更新子串的长度的时候，使用 i-left就是长度，而无需加一[不够准确]。
        int left = -1;  // 滑动窗口的左指针
        int res = 0;  // 结果
        int len = str.length();
        for(int i=0;i<len;i++){
            // 取出当前的字符
            char ch = str.charAt(i);
            // 如果之前已经存在，那么更新左指针的值（这样做的目的：找出重复字符的第一次出现的位置）
            // 使用 Math 的 max 方法的原因：跳过左边重复而且已经被忽略的元素。eg：abba： 当i为3的时候，如果不取Max，
            // 那么 left 的指针指向的就是 0，而【0，left】这个范围中还包含着重复的元素，因此不符合要求。
            if(map.containsKey(ch)) left = Math.max(left,map.get(ch));
            // 将 ch 字符的出现的索引更新为 i（当前索引）。
            map.put(ch,i);
            // 每次循环都更新 res 的值。
            res = Math.max(res,i-left);
        }
        return res;
    }

    /**
     * left 左指针初始化为 0 的情况。
     * abba
     */
    public static int lengthOfLongestSubstring2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // 初始化为0
        int res = 0; // 结果
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                // 更新left到重复字符的下一个位置
                left = Math.max(left, map.get(ch) + 1);  // left 左指针初始化为 0 的情况差异信息
            }
            // 将 ch 字符的出现的索引更新为 i（当前索引）。
            map.put(ch, i);
            // 每次循环都更新 res 的值，注意left需要加1
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
