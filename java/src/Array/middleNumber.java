package src.Array;

import java.util.ArrayList;

/**
 * 读取数据流中的中位数
 * 使用插入排序
 */
public class middleNumber {

    private ArrayList<Integer> val = new ArrayList<Integer>();

    public void Insert(Integer num) {
        // 如果没有数据，直接插入
        if (val.isEmpty()){
            val.add(num);
        }
        // 如果有数据则执行插入排序
        else {
            int i = 0;
            for(; i< val.size(); i++){
                if (val.get(i) <= num)
                    break;
            }
            val.add(i,num);
        }
    }

    public Double GetMedian() {
        int n = val.size();
        //奇数个数字
        if (n % 2 == 1)
            //类型转换
            return (double) val.get(n / 2);
            //偶数个数字
        else {
            double a = val.get(n / 2);
            double b = val.get(n / 2 - 1);
            return (a + b) / 2;
        }
    }
}
