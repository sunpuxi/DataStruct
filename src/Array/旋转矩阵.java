package src.Array;

public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<(n+1)/2;j++){
                // 暂存 A 的值
                int temp = matrix[i][j];
                // 将 D 赋值给 A
                matrix[i][j] = matrix[n-1-j][i];
                // 将 C 赋值给 D
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                // 将 B 赋值给 C
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                // 将 temp 赋值给 B
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
