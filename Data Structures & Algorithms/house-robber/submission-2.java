class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        if (nums.length <= 2) return Math.max(nums[0], nums[1]);
        int[] maxMoney = new int[nums.length];

        //1. Create base case

        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);
        //2. Formula 
        for (int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max((maxMoney[i - 2] + nums[i]), maxMoney[i - 1]);
        }
        return maxMoney[nums.length - 1];
    }
}
