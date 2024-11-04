package src.String;

public class 小数转二进制字符串 {
    public String printBin(double num) {
        StringBuilder sb  = new StringBuilder("0.");
        for(int i=0;i<6;i++){
            num *= 2;
            if(num < 1) sb.append('0');
            else{
                sb.append('1');
                if(--num == 0) return sb.toString();
            }
        }
        return "ERROR";
    }
}
