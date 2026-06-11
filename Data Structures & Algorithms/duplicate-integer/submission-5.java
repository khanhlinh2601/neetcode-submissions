class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num: nums) {
            if (result.contains(num)) {
                return true;
            }
            result.add(num);
        }
        return false;
    }
}