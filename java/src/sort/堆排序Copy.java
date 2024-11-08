package src.sort;


/**
 * 1、构建堆
 * 2、依次交换元素，调整堆
 */
public class 堆排序Copy {
    /**
     * 构建最大堆
     *
     * @param arr 数组
     * @param n   长度
     */
    public static void buildMaxHeap(int[] arr, int n) {
        // 1、构建堆
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,i,n);
        }
    }

    /**
     * 堆调整
     *
     * @param arr 数组
     * @param i   根节点
     */
    public static void heapify(int[] arr, int i,int n) {
        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && arr[max] < arr[left]) max = left;
        if(right < n && arr[max] < arr[right]) max = right;
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr,max,n);
        }
    }

    /**
     * 堆排序
     * @param arr 数组
     */
    public static void HeapSort(int[] arr){
        // 构建堆
        buildMaxHeap(arr,arr.length);
        // 将堆顶的元素与数组的末尾元素交换
        for(int i=arr.length-1;i>=0;i--){
            int max = arr[0];
            arr[0] = arr[i];
            arr[i] = max;
            // 重新构建堆
            heapify(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort(arr);
        System.out.println("Sorted array is:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
