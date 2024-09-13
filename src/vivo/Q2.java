package src.vivo;

import java.util.Arrays;

/**
 * 找出波动范围
 */
public class Q2 {
    public static int[] findFluctuations (int[] memoryUsage, int k) {
        if (memoryUsage == null || memoryUsage.length == 0) return new int[0];
        int[] res = new int[memoryUsage.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i;j< i+k ;j++){
                if (memoryUsage[j] > max){
                    max = memoryUsage[j];
                }
                if (memoryUsage[j] < min){
                    min = memoryUsage[j];
                }
            }
            res[i] = max-min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {80,100,70,90,60,85,75,95,110};
        int[] fluctuations = findFluctuations(arr, 4);
        String s = Arrays.toString(fluctuations);
        System.out.println(s);
    }
}
