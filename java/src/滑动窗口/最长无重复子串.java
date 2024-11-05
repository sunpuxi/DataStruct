package src.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最长无重复子串 {

    public int getLen(String str){
        Map<Character,Integer> map = new HashMap<>();
        int left = -1;  // 滑动窗口的左指针
        int res = 0;  // 结果
        int len = str.length();
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            if (map.containsKey(ch)){
                left = Math.max(left,map.get(ch));
                // 计算当前的滑动窗口的最大值
                res = Math.max(res,i-left);
            }
            // 更新字母 ch 的最后出现的位置
            map.put(ch,i);
        }
        return res;
    }
}
