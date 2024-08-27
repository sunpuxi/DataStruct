package src.Array;

import java.util.ArrayList;

/**
 * 最小的 k 个数字
 * 1、解法一：使用快排然后取出前k个元素
 * 2、解法二：将前 K 个元素加入栈中，依次遍历剩余的元素，找出栈中最大的元素替换，重复这个过程。
 */
public class minKNumbers {

    public static void main(String[] args) {
        minKNumbers minKNumbers = new minKNumbers();
        int[] nums = {5,1,6,3,4,2,7};
        ArrayList<Integer> integers = minKNumbers.GetLeastNumbers_Solution(nums, 4);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0 || input.length == 0) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        quickSort(input,0, input.length-1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public  void quickSort(int[] arr, int i, int j){
        int start = i;
        int end = j;
        if (start>=end) return;
        int pivot = arr[start];
        while(start!=end){
            while(true){
                if (end<=start||arr[end]<pivot){
                    break;
                }
                end--;
            }
            while(true){
                if (end<=start || arr[start]>pivot){
                    break;
                }
                start++;
            }
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        quickSort(arr,i,start-1);
        quickSort(arr,start+1,j);
    }
}
