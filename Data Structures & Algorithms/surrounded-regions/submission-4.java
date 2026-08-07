class Solution {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        // STEP 1: Run DFS from all 'O' cells on the border
        for (int i = 0; i < rows; i++) {
            dfs(board, i, cols - 1);
            dfs(board, i, 0);
        }
        for (int i = 0; i < cols; i++) {
            dfs(board, rows - 1, i);
            dfs(board, 0, i);
        }
        // STEP 2: Final sweep (Flip 'O' -> 'X' and 'E' -> 'O')
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >=board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'E';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);

    }
}
