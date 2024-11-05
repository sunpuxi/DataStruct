package src.stack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 对字符串进行解码
 */
public class StringEncoding {

    /**
     * 解法一
     * @param s
     * @return
     */
    public String decodeString(String s) {
        // 一个栈记录循环拼接的次数
        Deque<Integer> numDeque = new LinkedList<>();
        // 一个栈记录要循环拼接的字符
        Deque<String> strDeque = new LinkedList<>();
        // 初始化
        int num = 0;
        String str = "";
        // 遍历 s
        for (int i = 0; i < s.length(); i++){
            // 取出当前的字符
            char c = s.charAt(i);
            // 如果当前的字符是数字
            if (Character.isDigit(c)){
                // 将 num 添加到 numDeque 中。注意此处的 num 不一定只有一位数
                num = num * 10 + c - '0';
            }else if(c == '['){
                // 如果是左括号
                // 将num和str加入到对应的栈中
                numDeque.push(num);
                strDeque.push(str);
                // 重置
                num = 0;
                str = "";
            } else if (c == ']') {
                // 如果是右括号
                // 弹出 numDeque 中的数字作为循环拼接的次数
                int count = numDeque.poll();
                StringBuilder sb = new StringBuilder();
                // 弹出 strDeque 中的第一个字符作为前缀开始拼接
                sb.append(strDeque.poll());
                while(count-->0){
                    sb.append(str);
                }
                str = sb.toString();
            } else{
              // 如果是字符，那么继续拼接
              str += c;
            }
        }
        return str;
    }

    /**
     * 解法二
     */
    public String decodeString2(String s) {
        Stack<StringBuilder> stackStr = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        StringBuilder currentStr = new StringBuilder();

        int k = 0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }else if(ch == '['){
                stackNum.push(k);
                stackStr.push(currentStr);
                k = 0;
                currentStr = new StringBuilder();
            }else if(ch == ']'){
                StringBuilder decodedStr = stackStr.pop();
                int repeatTime = stackNum.pop();
                for(int i=0;i<repeatTime;i++){
                    decodedStr.append(currentStr);
                }
                currentStr = decodedStr;
            }else{
                currentStr.append(ch);
            }
        }
        return currentStr.toString();
    }
}
