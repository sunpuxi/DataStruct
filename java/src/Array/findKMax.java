package src.Array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找到数组中第 k 大的元素
 */
public class findKMax {
    public int findKth(int[] a, int n, int K) {
        if (n == 0) return 0;
        quickSort(a, 0, n - 1);
        return a[n - K];
    }

    public void quickSort(int[] arr, int i, int j) {
        int start = i;
        int end = j;
        if (start >= end) return;
        int pivot = arr[start];
        while (start != end) {
            while (true) {
                if (end <= start || arr[end] < pivot) {
                    break;
                }
                end--;
            }
            while (true) {
                if (end <= start || arr[start] > pivot) {
                    break;
                }
                start++;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        quickSort(arr, i, start - 1);
        quickSort(arr, start + 1, j);
    }

    public int heapSortToGetKNumber(int[] nums,int k){
        // 优先队列，默认为最大堆
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            // 如果当前的堆中的元素数量小于K个
            if(queue.size() < k){
                queue.add(num);
            }
            // 如果堆中的元素数量大于等于K个
            else {
                int poll = queue.poll();
                // 需要注意堆中的元素数量始终为K个。
                queue.add(Math.max(poll, num));
            }
        }
        // 返回堆中的最后一个元素
        return queue.poll();
    }

    public static void main(String[] args) {
        findKMax findKMax = new findKMax();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findKMax.heapSortToGetKNumber(arr, 3));
    }
}
