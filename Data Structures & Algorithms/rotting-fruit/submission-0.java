class Solution {
    public static int orangesRotting(int[][] grid) {
            //Queue rotten fruit
        Queue<int[]> rottenFruits = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) {
                 if (grid[i][j] == 2) {
                     rottenFruits.add(new int[]{i, j});
                 }
             }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        int freshFruits = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }
        while (!rottenFruits.isEmpty() && freshFruits > 0) {
            //get the first element
            int size = rottenFruits.size(); //handle each level
            for (int i = 0; i < size; i++) {
                int[] rottenFruit = rottenFruits.poll();
                for (int[] direction : directions) {
                    int x = rottenFruit[0] + direction[0];
                    int y = rottenFruit[1] + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshFruits--;
                        rottenFruits.add(new int[]{x, y});
                    }
                }
            }
            result++;
        }
        return freshFruits == 0 ? result : -1;
    }

}
