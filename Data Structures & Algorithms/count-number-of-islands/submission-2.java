class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(visited, grid, i, j);
                    count++;
                }
                
            }
            
        }
        return count;
        
        
    }

    private void dfs(boolean[][] visited,char[][] grid, int r, int c) {
        //check border
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;

        if (grid[r][c] == '0' || visited[r][c]) return;

        visited[r][c] = true;

        dfs(visited, grid, r + 1, c);
        dfs(visited, grid, r - 1, c);
        dfs(visited, grid, r, c + 1);
        dfs(visited, grid, r, c - 1);

    }

}
