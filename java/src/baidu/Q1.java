package src.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[5];
            for (int i1 = 0; i1 < 5; i1++) {
                arr[i1] = sc.nextInt();
            }
            list.add(arr);
        }
        // end input
        // 2 3 1 2 3
        for (int[] ints : list) {
            Arrays.sort(ints);
            int sum = 1;
            int m = ints[4] - ints.length-1;  // 可以加二的数字的个数
            for (int i = 0; i < ints.length-1; i++) {
                if (m > 0 && ints[4] > 0){
                    ints[4]-=2;
                    ints[i]+=2;
                    m--;
                }else if (m <= 0 && ints[4] > 0){
                    ints[i]++;
                    ints[4]--;
                }
                sum *= ints[i];
            }
            System.out.println(sum);
        }
    }
}
