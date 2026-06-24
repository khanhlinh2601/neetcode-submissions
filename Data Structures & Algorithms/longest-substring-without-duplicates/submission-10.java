class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
