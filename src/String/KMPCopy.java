package src.String;

public class KMPCopy {

    public static int kmp(String text, String pattern) {
        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        while(i < text.length()){
            // 如果两个元素相同，继续匹配剩余的元素
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            // 如果此时的 j 已经等于 pattern 的长度，那么表示全部匹配
            if (j == pattern.length()){
                return i - j;
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                // 此时发生元素不匹配，根据 j 的位置，进行模板字符串的移动
                if (j != 0){
                    j = next[j - 1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }

    // 计算前缀表
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;  // 初始化
        int i = 1;
        int len = 0;  // 最长相等前后缀的长度
        while(i < pattern.length()){
            // 如果 i 索引处的元素等于 len 索引处的元素，那么 len++，并更新前缀表
            if (pattern.charAt(i) == pattern.charAt(len)){
                len++;
                next[i] = len;
                i++;
            }else{
                // 如果不想等，判断 len 是否等于 0 ；
                if (len != 0){
                    // 更新 len 的大小
                    len = next[len-1];
                    // 此时的 i 不能更新，需要重新匹配
                }else{
                    next[i] = 0;
                    // 后移一位
                    i++;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int index = kmp(text, pattern);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
