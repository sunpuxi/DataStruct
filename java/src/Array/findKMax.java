package src.Array;

/**
 * 找到数组中第 k 大的元素
 */
public class findKMax {
    public int findKth (int[] a, int n, int K) {
        if (n == 0) return 0;
        quickSort(a,0,n-1);
        return a[n-K];
    }

    public void quickSort(int[] arr,int i,int j){
        int start = i;
        int end = j;
        if (start>=end) return;
        int pivot = arr[start];
        while(start != end){
            while (true){
                if (end<=start||arr[end]<pivot){
                    break;
                }
                end--;
            }
            while (true){
                if (end<=start||arr[start]>pivot){
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
        quickSort(arr,i,start-1);
        quickSort(arr,start+1,j);
    }
}
