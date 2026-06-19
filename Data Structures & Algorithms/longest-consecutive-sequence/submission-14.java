class Solution {
     public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        int res = 1;
        int streak = 1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                streak++;
                continue;
            }
            res = Math.max(res, streak);
            streak = 1;
        }
        return Math.max(res, streak);
    }
}
