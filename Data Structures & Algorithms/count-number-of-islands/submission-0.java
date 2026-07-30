class Solution {
    
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }
    public static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row - 1, col, visited); // up
        dfs(grid, row + 1, col, visited); // down
        dfs(grid, row, col - 1, visited); // left
        dfs(grid, row, col + 1, visited); // right
    }
}
