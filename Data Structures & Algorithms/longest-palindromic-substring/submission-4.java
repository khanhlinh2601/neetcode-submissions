class Solution {
    public static String longestPalindrome(String s) {
        int resultLen = 0;
        int resIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd
            int left = i, right = i;
            while (left <= right && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLen) {
                    resultLen = right - left + 1;
                    resIndex = left;
                }
                left--;
                right++;
            }

            //even
            left = i;
            right = i + 1;
            while (left <= right && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLen) {
                    resultLen = right - left + 1;
                    resIndex = left;
                }
                left--;
                right++;
            }


        }
        return resultLen == 0 ? "" : s.substring(resIndex, resIndex + resultLen);
    }

}
