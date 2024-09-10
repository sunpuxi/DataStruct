package src.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的组合问题
 */
public class TelephoneNumberMixed {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 特殊
        if (digits == null || digits.length() == 0) return list;
        // 初始化数字的映射数组
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 从digits 中的第一个元素对应的字符开始拼接
        backTrack(numString,digits,0);
        return list;
    }

    StringBuilder sb = new StringBuilder();


    /**
     * 回溯
     *
     * @param numString 字符数组实现
     * @param digits    输入的数字字符
     * @param num       数字字符的元素的索引
     */
    public void backTrack(String[] numString, String digits, int num) {
        // 终止条件
        if (sb.length() == digits.length()){
            list.add(sb.toString());
            return;
        }
        // 取出digits中num位置处对应的元素
        String str = numString[digits.charAt(num) - '0'];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            backTrack(numString, digits, num + 1);
            sb.setLength(sb.length()-1);
        }
    }
}
