class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    sum *= nums[j];
                }
            }
            res[i] = sum;
            sum = 1;
        }
        return res;
    }
}  
