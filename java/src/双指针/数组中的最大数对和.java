package src.双指针;

import java.util.*;

public class 数组中的最大数对和 {

    /**
     * 优化版本
     * 时间复杂度：O(n)，其中n是数组的长度。我们只需要遍历数组一次。
     * 空间复杂度：O(1)，我们使用了一个固定大小的数组来存储每个数位对应的最大值。
     * @param nums
     * @return
     */
    public int maxSum(int[] nums) {
        // 使用数组来存储每个数位对应的最大值，数位的范围是0-9，所以数组大小为10
        int[] maxAtDigit = new int[10];
        Arrays.fill(maxAtDigit, -1); // 初始化为-1，表示没有出现过
        int maxSum = 0; // 存储最大和
        for (int num : nums) {
            int maxDigit = getTheMaxNumber(num);
            // 如果当前数位已经出现过，并且对应的最大值不为-1，则计算和并更新最大和
            if (maxAtDigit[maxDigit] != -1) {
                maxSum = Math.max(maxSum, num + maxAtDigit[maxDigit]);
            }
            // 更新当前数位对应的最大值
            maxAtDigit[maxDigit] = Math.max(maxAtDigit[maxDigit], num);
        }
        return maxSum;
    }

    public int getTheMaxNumber(int num) {
        int maxDigit = 0;
        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            num /= 10;
        }
        return maxDigit;
    }


    /**
     * 时间：O(n*m) n 为数组的长度，m 为一个数字的长度。
     * 空间：O（m*n）
     * @param nums
     * @return
     */
    public int maxSum1(int[] nums) {
        // 首先要满足最大数字相等，再去谈求和的问题
        // 从前往后遍历的同时，将这个数的最大数位设置为Map中的key，value就是这个数
        // 然后每次遍历到一个数时，就看前面是否存在过跟他最大数位相同的情况，如果存在则求和计算，更新最大值，不存在则重复上面的步骤。
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = -1;
        for(int num : nums){
            int number = getTheMaxNumber1(num);
            if(map.containsKey(number)){
                List<Integer> list = map.get(number);
                int m = 0;
                // 找出集合中存在的最大元素
                for(int i:list) m = Math.max(i,m);
                // 更新最大值
                max = Math.max(max,num + m);
                // 将当前的元素添加到集合中
                list.add(num);
                map.put(number,list);
            }else{
                List<Integer> list  = new ArrayList<>();
                list.add(num);
                map.put(number,list);
            }
        }
        return max;
    }

    public int getTheMaxNumber1(int num){
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        int max = 0;
        for(char ch : arr){
            int a = ch - '0';
            max = Math.max(a,max);
        }
        return max;
    }
}
