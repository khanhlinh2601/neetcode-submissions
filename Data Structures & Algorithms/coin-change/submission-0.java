class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //1. Create state dp i: is the minium coin to change = amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; 
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
                
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
