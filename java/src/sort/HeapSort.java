package src.sort;

public class HeapSort {
    /**
     * 交换堆顶与堆底的元素，缩小堆的长度，继续对剩余的元素进行建堆
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Floyd 建堆(时间复杂度 O（n）)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        //交换堆顶和堆底的元素，并继续进行建堆
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // largest 为当前的跟节点的索引
        int l = 2 * i + 1;  //左孩子的索引
        int r = l + 1;  //右孩子的索引

        //左右孩子节点没有越界的情况下，交换跟节点和较大的孩子节点的值
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}