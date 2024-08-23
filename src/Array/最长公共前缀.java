package src.Array;

/**
 * 最长公共前缀
 * 纵向扫描
 */
public class 最长公共前缀 {
    public String getPrefix(String[] strs){
        if (strs == null) return "";
        if (strs.length == 1) return strs[0];
        int cols = strs[0].length();
        int row = strs.length;
        // 以第一行字符串的信息为基准
        for(int i=0;i<cols;i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<row;j++){
                if (strs[j].length() == i || strs[j].charAt(i) != ch)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
    // test git
}
