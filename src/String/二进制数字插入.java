package src.String;

/**
 * 转换为位运算
 */
public class 二进制数字插入 {
    public int insertBits(int N, int M, int i, int j) {
        int mask = (0xffffffff << j << 1) + ((1 << i) - 1);
        return N & mask | M << i;
    }
}
