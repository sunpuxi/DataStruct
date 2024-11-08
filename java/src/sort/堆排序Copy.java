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
        // 从最后一个不是叶子节点的节点开始构建
        // 数组的第一个节点是最大的节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * 堆调整
     *
     * @param arr 数组
     * @param i   根节点
     * @param n   数组长度
     */
    public static void heapify(int[] arr, int i, int n) {
        // 初始化
        int largest = i;
        int left = 2 * i + 1;  // 根节点的左孩子节点的下标
        int right = 2 * i + 2;  // 根节点的右孩子节点的下标
        // 如果左孩子节点比根节点大
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        // 如果右孩子节点的值大于根节点
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }
        // 如果最大值的下标索引不是 i
        // 交换根节点与堆中最大元素的值
        if(largest != i){
            int max = arr[largest];
            arr[largest] = arr[i];
            arr[i] = max;
            // 调整了这一个子堆之后，其他受影响的堆也需要改变
            // 受影响的堆的跟节点的下标为 largest
            heapify(arr,largest,n);
        }
    }

    /**
     * 堆排序
     * @param arr 数组
     * @param n 数组的长度
     * @return 排序后的数组
     */
    public static void HeapSort(int[] arr,int n){
        // 1、首先构建堆
        buildMaxHeap(arr,n);
        // 2、依次将根节点与数组的末尾节点交换，使得最大值排在数组的末尾，然后调整剩余部分的堆结构
        for(int i=n-1;i>=0;i--){
            int max = arr[0];
            arr[0] = arr[i];
            arr[i] = max;
            // 由于每一次调整根节点，都是数组的第一个元素
            // 因此第二个参数的值一直传0
            // 第三个参数代表数组的末尾节点
            // 由于交换一次，最后一个元素的值都是有序的，因此需要传 i。（i一直在减减）
            heapify(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort(arr, arr.length);
        System.out.println("Sorted array is:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
