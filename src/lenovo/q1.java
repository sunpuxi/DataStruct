package src.lenovo;

public class q1 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        arr[0] = 1;
        arr[1] = 2;
        for(int i=2;i<8;i++) arr[i] = arr[i-1] + arr[i-2];
        System.out.println(arr[7]);
    }
}
