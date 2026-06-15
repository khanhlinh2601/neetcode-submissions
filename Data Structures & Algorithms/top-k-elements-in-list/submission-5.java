class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }
        Collections.sort(list, (o1, o2) -> o2[0] - o1[0]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }
        return result;
    }
}
