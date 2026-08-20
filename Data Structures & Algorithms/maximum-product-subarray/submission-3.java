class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int leftSoFar = 1;
        int rightSoFar = 1;

        for (int i = 0; i < n; i++){
            if (leftSoFar == 0) {
                leftSoFar = 1;
            }
            if (rightSoFar == 0) {
                rightSoFar = 1;
            }
        
            leftSoFar *= nums[i];
            rightSoFar *= nums[n - 1 - i];

            int tmp = Math.max(leftSoFar, rightSoFar);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
