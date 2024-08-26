package src.String;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断括号是否合法
 */
public class isValidChar {
    public boolean isValid (String s) {
        if (s == null || s.length() == 1) return false;
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (char aChar : chars) {
            if (aChar == '{') deque.addLast('}');
            else if (aChar == '[') deque.addLast(']');
            else if (aChar == '(') deque.addLast(')');
            else if(deque.isEmpty()) return false;
            else {
                char c = deque.removeLast();
                if(c != aChar) return false;
            }
        }
        return deque.isEmpty();
    }
}
