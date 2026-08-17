class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;
        int maxIndex = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (str[i] == str[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    int currentLen = j - i + 1;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        maxIndex = i;
                    }
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLen);
    }
}
