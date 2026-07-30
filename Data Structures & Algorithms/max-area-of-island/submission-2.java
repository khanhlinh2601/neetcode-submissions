class Solution {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    int area = 0;
                    for (int r = 0; r < grid.length; r++) {
                        for (int c = 0; c < grid[0].length; c++) {
                            if (visited[r][c]) {
                                area++;
                                visited[r][c] = false;
                            }
                        }
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }
        return maxArea;
    }
    public static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row - 1, col, visited); // up
        dfs(grid, row + 1, col, visited); // down
        dfs(grid, row, col - 1, visited); // left
        dfs(grid, row, col + 1, visited); // right
    }
}
