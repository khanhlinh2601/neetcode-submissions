class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0; //first row
        int col = matrix[0].length - 1; //last column
        while (row < matrix.length && col >=0 ) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
