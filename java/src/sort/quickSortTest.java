package src.sort;

public class quickSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,7,12,0,3,45};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * 快速排序
     * @param arr，需要排序的数组
     * @param i  数组的起始索引
     * @param j  数组的结束索引
     */
    public static void quickSort(int[] arr, int i, int j){
        int start = i,end = j;
        if (start >= end) return;
        int pivot = arr[i];
        while(start < end){
            // 先找后面
            while(start < end && arr[end] >= pivot) end--;
            while (start < end && arr[start] <= pivot) start++;
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        quickSort(arr,i,start-1);
        quickSort(arr,start+1,j);
    }
}
