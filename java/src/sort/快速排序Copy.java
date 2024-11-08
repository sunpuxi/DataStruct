package src.sort;

/**
 * 快速排序的原理：
 * 1、起始索引为 i
 * 2、从左往右找比 arr【i】大的第一个元素arr【left】，从右往左找第一个比arr【ℹ】小的元素arr【right】
 * 3、交换这两个元素的位置，left和right
 * 4、交换arr【ℹ️】和arr【left】。
 * 5、递归的执行这个过程
 */
public class 快速排序Copy {
    public static void QuickSort(int[] arr, int i, int j) {
        if (i >= j) return;
        int pivot = i;  // 参考元素
        int left = i;  // 找左边第一个元素
        int right = j;  // 找右边第一个元素
        // 找第一个元素
        while (true) {
            if (left < right && arr[left] >= arr[pivot]) break;
            else left++;
        }
        // 找第二个元素
        while (true) {
            if (left < right && arr[right] <= arr[pivot]) break;
            else right++;
        }
        // 交换这两个元素
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        // 交换pivot和left
        int temp1 = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = temp1;
        // 递归
        QuickSort(arr,i,left-1);
        QuickSort(arr,left+1,j);
    }
}
