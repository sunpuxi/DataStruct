package src.String;

/**
 * 大数加法
 */
public class PlusOfBigNumber {
    public static String solve (String s, String t) {
        char[] arr = new char[Math.max(s.length(),t.length())+1];
        int p = 0;  // 进位
        int index = arr.length-1;
        for(int i=s.length()-1,j=t.length()-1;i>=0 || j>=0;i--,j--){
            int x = 0,y=0;
            if (i>=0) x = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (j>=0) y = Integer.parseInt(String.valueOf(t.charAt(j)));
            int num = x + y + p;
            p = num > 9 ? 1 : 0;
            char c = Character.forDigit(num%10,10);
            arr[index--] = c;
        }
        if (p==1){
            arr[index] = '1';
            return new String(arr);
        }else return new String(arr,1, arr.length-1);

    }

    public static void main(String[] args) {
        String s= "1";
        String t="99";
        String solve = solve(s, t);
        System.out.println(solve);
    }
}
