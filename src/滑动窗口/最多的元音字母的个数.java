package src.滑动窗口;

/**
 * 找出一个给定的字符串的k定长子序列钟存在最多的元音字符的个数
 * 1、解法一：使用暴力解法枚举所有的子串，时间复杂度O（nK），有可能超时
 * 2、滑动窗口：不枚举所有的子串
 */
public class 最多的元音字母的个数 {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int count  = 0; // 统计元音字符的个数
        int max = 0; // 记录最大的元音字符的个数
        for (int i = 0; i < chars.length; i++) {
            // 进入滑动窗口
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u')
                count++;
            // 判断是否达到定长
            if (i<k-1)
                continue;
            // 更新
            max = Math.max(max,count);
            // 出窗口
            char left = chars[i - k + 1];
            if (left == 'a' || left == 'e' || left == 'i' || left == 'o' || left == 'u')
                count--;
        }
        return max;
    }
}
