package src.String;

/**
 * @author Sxuet
 * @program LeetCode
 */
public class 字符串压缩 {
    public static String compressString(String S) {
        if(S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            sb.append(ch);
            int count = 1;
            int index = i + 1;
            while (index < S.length() && S.charAt(index) == ch){
                count++;
                index++;
            }
            sb.append(count);
            i = index - 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
