package src.Array;

import java.util.PriorityQueue;

/**
 * 基于优先队列实现
 * 优先队列的容量设置为K
 * 首先将数组中的前K个元素添加到优先队列中，然后依次弹出比较即可。
 * 优先队列可以理解为一个大根堆
 */
public class 前K个最大的元素 {

    public static void solution(int[] arr,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for (int i : arr) {
            if (maxHeap.size() < k) maxHeap.add(i);
            else{
                if (i >= maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(i);
                }
            }
        }
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,8,7,6,1,4,5};
        solution(arr,3);
    }
}
