package src.sort;

import java.util.Random;

public class quickSortTest {

    public static void main(String[] args) {
        int arr[] = new int[100000];
        Random r = new Random();
        for (int i : arr) {
            arr[i] = r.nextInt();
        }
        long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end- start);
    }


    /**
     * 快速排序
     * @param arr，需要排序的数组
     * @param i  数组的起始索引
     * @param j  数组的结束索引
     */
    public static void quickSort(int[] arr, int i, int j){
        int start = i,end = j;
        //递归的出口
        if(start >= end) return;
        //第一遍找出第一个元素在数组中的位置
        int pivot = arr[start];
        //找出 end 向前遍历比 pivot 小的数字，找出 start 向前遍历得到的数字，交换，然后重复这个过程
        while(start != end){
            while(true){
                if(end <= start || arr[end] < pivot){
                    break;
                }
                end--;
            }
            while(true){
                if(end <= start || arr[start] > pivot){
                    break;
                }
                start++;
            }
            //交换元素
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        //结束循环之后，start 和 end 指向的位置即为 pivot 该存放的位置
        //将 pivot 归位
        int tmp = arr[i];
        arr[i] = arr[start];
        arr[start] = tmp;

        quickSort(arr,i,start-1);
        quickSort(arr,start+1,j);
    }
}
