class Solution {
    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }
        
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> seen = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];
                        if (c == '.') continue;
                        if (seen.contains(c)) return false;
                        seen.add(c);
                    }
                }
            }
        }
        return true;
    }
}
