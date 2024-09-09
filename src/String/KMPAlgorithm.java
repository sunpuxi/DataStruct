package src.String;

public class KMPAlgorithm {

    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // text的索引
        int j = 0; // pattern的索引
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                // 找到匹配，返回模式串在主串中的起始索引
                return i - j;
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                // 不匹配，移动模式串的索引
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        // 未找到匹配
        return -1;
    }

    /**
     * 计算最长公共前后缀数组（Longest Prefix Suffix）
     * @param pattern 模式串
     * @return 最长公共前后缀数组
     */
    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // 计算lps[i]的值
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int index = kmpSearch(text, pattern);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
