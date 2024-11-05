package src.lenovo;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    int dfs = dfs(arr, i, j, arr[i][j]);
                    sum = Math.max(sum,dfs);
                }
            }
        }
        System.out.println(sum);
    }

    public static int dfs(int[][] arr,int i,int j,int sum){

        if (i-1 >=0) sum += arr[i-1][j];
        if (j-1>=0 ) sum += arr[i][j-1];
        if (i+1 < arr.length) sum += arr[i+1][j];
        if (j+1 < arr[0].length) sum += arr[i][j+1];

        return sum;
    }
}
