class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            //odd
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                result++;
                left--;
                right++;
            }
            left = i; 
            right = i + 1;
            //even
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
    
    
}
