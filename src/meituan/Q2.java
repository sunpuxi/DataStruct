package src.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {

            int n = in.nextInt();  // 工人
            int k = in.nextInt();  // 树的数量
            int[] pisition = new int[n];
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<pisition.length;i++) pisition[i] = in.nextInt();
            int least = k / n;  // 每个人至少要种的树的数量

            while(set.size() < k){
                for(int p : pisition){
                    set.add(p);
                    int number = least - 1;
                    while(number > 0){
                        set.add(p+number);
                        number--;
                    }
                }
                if(set.size() < k){
                    least++;
                    set.clear();
                }
            }
            System.out.print(least);
        }
    }

}
