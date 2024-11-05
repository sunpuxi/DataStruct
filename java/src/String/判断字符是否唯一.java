package src.String;

/**
 * 从二进制的角度看 num：0000 0010
 * 右边的第二位是 1 代表字符中出现过 b 字符
 */
public class 判断字符是否唯一 {
    public boolean isUnique(String astr) {
        int len = astr.length();
        if(len > 26) return false;
        int num = 0;
        for(int i = 0;i < len; i++){
            char ch = astr.charAt(i);
            int index = ch - 'a';
            if((num & (1 << index)) != 0) return false;
            else num |= (1 << index);
        }
        return true;
    }
}
