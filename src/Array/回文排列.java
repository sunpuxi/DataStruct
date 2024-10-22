package src.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出字符串是否可以由回文字符串构成
 */
public class 回文排列 {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd = 0;
        for(int val : map.values()){
            if(val % 2 == 1){
                if(++odd > 1){
                    return false;
                }
            }
        }
        return true;
    }
}