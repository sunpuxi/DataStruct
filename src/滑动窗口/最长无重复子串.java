package src.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最长无重复子串 {

    public int getLen(String str){
        Map<Character,Integer> map = new HashMap<>();
        int left = -1;
        int len = str.length();
        int maxLen = 0;
        for(int i = 0; i < len;i++){
            if (map.containsKey(str.charAt(i)))
                left = Math.max(left,map.get(str.charAt(i)));
            map.put(str.charAt(i),i);
            maxLen = Math.max(maxLen,i - left);
        }
        return maxLen;
    }
}
