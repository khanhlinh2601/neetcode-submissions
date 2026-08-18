class Solution {
    public static int countSubstrings(String s) {
        int total = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            total += countPalindromic(s, i, i);
            total += countPalindromic(s, i, i + 1);
        }
        return total;
    }
    private static int countPalindromic(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }
}
