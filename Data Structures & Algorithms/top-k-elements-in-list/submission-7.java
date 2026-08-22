class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int key = map.get(num);
            if (buckets[key] == null) {
                buckets[key] = new ArrayList<>();
            }
            buckets[key].add(num);
        }
        int[] ans = new int[k];
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans[--k] = num;
                }
            }
        }
        return ans;
    }
}
