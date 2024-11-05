package src.Array;

/**
 * 找出数组中只出现一次的两个数字
 */
public class twoNumbers {
    public int[] FindNumsAppearOnce (int[] array) {
        int res1 = 0;
        int res2 = 0;
        int temp = 0;
        //遍历数组得到a^b
        for (int j : array) temp ^= j;
        int k = 1;
        //找到两个数不相同的第一位
        while((k & temp) == 0)
            k <<= 1;
        for (int j : array) {
            //遍历数组，对每个数分类
            if ((k & j) == 0)
                res1 ^= j;
            else
                res2 ^= j;
        }
        //整理次序
        if(res1 < res2)
            return new int[] {res1, res2};
        else
            return new int[] {res2, res1};
    }
}
