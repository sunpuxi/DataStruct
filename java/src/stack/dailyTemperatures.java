package src.stack;

/**
 * 每日温度
 */
public class dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        // 从后往前遍历，利用之前的数组进行跳跃
        int[] answer = new int[temperatures.length];
        // 遍历
        for (int i = temperatures.length-2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += answer[j]) {
                if (temperatures[j] > temperatures[i]){
                    answer[i] = j - i;
                    break;
                }else if(answer[j] == 0){
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
