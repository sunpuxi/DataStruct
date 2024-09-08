package src.String;

public class KMPCopy {

    public static int kmp(String text, String pattern) {
        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            // 判断是否完全匹配
            if (j == pattern.length()) {
                return i - j;
            } else if (i<text.length() && text.charAt(i) != pattern.charAt(j)) {
                // 此时不匹配
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    // 计算前缀表
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int len = 0;
        int i = 1;
        next[0] = 0;
        while(i < pattern.length()){
            if (pattern.charAt(i) == pattern.charAt(len)){
                len++;
                next[i] = len;
                i++;
            }else{
                if (len != 0){
                    len = next[len-1];
                }else{
                    next[i] = len;
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
