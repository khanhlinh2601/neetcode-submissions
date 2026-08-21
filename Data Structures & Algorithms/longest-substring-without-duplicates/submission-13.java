class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s.isEmpty()) return 0;
        if (s.length() <= 1) return 1;
        Set<Character> sCharacters = new HashSet<>();
        int left = 0;
        

        for (int right = 0; right < s.length(); right++) {
            while (sCharacters.contains(s.charAt(right))) {
                sCharacters.remove(s.charAt(left));
                left++;
                
            }
            sCharacters.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
