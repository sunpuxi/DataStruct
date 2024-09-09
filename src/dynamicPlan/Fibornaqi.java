package src.dynamicPlan;

/**
 * 斐波那契数组
 * 非动态规划的解法
 */
public class Fibornaqi {
    public int solution(int n){
        if (n < 4) return n;
        int a=1,b=2,c=0;
        for(int i=2;i<n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
