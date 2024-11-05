package src.map;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class deadOrange {

    /**
     * 难点，每次感染橘子之后，需要找到每一个被感染的橘子，并在下一轮中，对这些腐烂的橘子进行感染操作。
     * @param grid
     * @return
     */

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) {
                    deque.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        while(!deque.isEmpty() && count > 0){
            time++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int l1 = poll[0];
                int l2 = poll[1];
                if (l1 - 1 >=0 && grid[l1-1][l2] == 1){
                    count--;
                    grid[l1-1][l2] = 2;
                    deque.offer(new int[]{l1-1,l2});
                }
                if (l1 + 1 <= grid.length-1 && grid[l1+1][l2] == 1){
                    count--;
                    grid[l1+1][l2] = 2;
                    deque.offer(new int[]{l1+1,l2});
                }
                if (l2 - 1 >=0 && grid[l1][l2-1] == 1){
                    count--;
                    grid[l1][l2 - 1] = 2;
                    deque.offer(new int[]{l1,l2 - 1});
                }
                if (l2 + 1 <= grid[0].length-1 && grid[l1][l2 + 1] == 1){
                    count--;
                    grid[l1][l2 + 1] = 2;
                    deque.offer(new int[]{l1,l2 + 1});
                }
            }
        }
        if (count > 0) return -1;
        else return time;
    }
}
