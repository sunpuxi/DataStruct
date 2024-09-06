package src.dynamicPlain;


/**
 * 爬楼梯
 * 每一次可以爬一台或者两台楼梯
 * 一个 n 台的楼梯有几种爬法
 */
public class jumpFloor {

    public static int solution(int number){
        int[] arr = new int[number];
        arr[0] = 1;
        arr[1] = 2;
        for(int i=2;i<number;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[number-1];
    }

    public static void main(String[] args) {
        int solution = solution(7);
        System.out.println(solution);
    }
}
