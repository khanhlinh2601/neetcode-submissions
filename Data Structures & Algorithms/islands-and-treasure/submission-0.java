class Solution {
    public static void islandsAndTreasure(int[][] grid) {
    
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //Hướng đi
        //add treasure into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : directions) {
                int x = cell[0] + direction[0];
                int y = cell[1] + direction[1];
                //check if x,y is in grid
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == Integer.MAX_VALUE ) {
                    grid[x][y] = grid[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }

        }
     }
}
