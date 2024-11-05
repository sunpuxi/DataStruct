package src.Array;


/**
 * 岛屿数量
 */
public class numberOfIsland {

    public int solve(char[][] grid) {
        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    number++;
                }
            }
        }
        return number;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 终止条件
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == '0') {
            return;
        }
        // 将每一个遍历到的岛屿节点改为 ‘0’
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        // 继续标记其他相邻的岛屿节点
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
