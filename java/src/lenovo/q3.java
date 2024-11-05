package src.lenovo;

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int i1 = Integer.parseInt(str.substring(i, j+1));
                if (i1 % 4 == 0) count++;
            }
        }
        System.out.println(count);
    }
}
