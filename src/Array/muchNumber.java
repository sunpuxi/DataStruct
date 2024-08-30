package src.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到数组中出现次数超过数组长度一半的数字
 */
public class muchNumber {
    public int MoreThanHalfNum_Solution (int[] numbers) {
        int len = numbers.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (!map.containsKey(number)) map.put(number,1);
            else map.put(number,map.get(number)+1);
            if (map.get(number) > len/2) return number;
        }
        return 0;
    }
}
