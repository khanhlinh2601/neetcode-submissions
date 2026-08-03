class Solution {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // Mảng đánh dấu các ô mà mỗi đại dương có thể "leo" tới
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Chạy DFS cho cột trái (Pacific) và cột phải (Atlantic)
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);                 // Biển Pacific (Trái)
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]);  // Biển Atlantic (Phải)
        }

        // 2. Chạy DFS cho hàng trên (Pacific) và hàng dưới (Atlantic)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);                 // Biển Pacific (Trên)
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]);  // Biển Atlantic (Dưới)
        }

        // 3. Tìm các ô chung mà CẢ HAI biển đều leo tới được
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Dừng lại nếu:
        // - Vượt ngoài phạm vi ma trận
        // - Ô này đã được thăm trước đó
        // - Ô tiếp theo THẤP HƠN ô trước đó (vì ta đang đi ngược từ thấp lên cao)
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c]
                || heights[r][c] < prevHeight) {
            return;
        }

        // Đánh dấu ô hiện tại đã chạm tới được
        visited[r][c] = true;

        // Gọi đệ quy 4 hướng kề bù
        dfs(heights, r - 1, c, visited, heights[r][c]); // Trên
        dfs(heights, r + 1, c, visited, heights[r][c]); // Dưới
        dfs(heights, r, c - 1, visited, heights[r][c]); // Trái
        dfs(heights, r, c + 1, visited, heights[r][c]); // Phải
    }

}
