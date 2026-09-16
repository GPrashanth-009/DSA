class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        
        // dp[i][j] = number of ways to form j segments using the first i points
        int[][] dp = new int[n][k + 1];
        
        // Base Case: 1 way to form 0 segments using any number of points
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        
        // Build the grid step-by-step
        for (int j = 1; j <= k; j++) {
            long runningSum = 0;
            for (int i = 1; i < n; i++) {
                // Add the ways to form j-1 segments up to the previous point
                runningSum = (runningSum + dp[i - 1][j - 1]) % MOD;
                
                // Total ways = (ways to skip this point) + (ways to end a segment here)
                dp[i][j] = (int) ((dp[i - 1][j] + runningSum) % MOD);
            }
        }
        
        return dp[n - 1][k];
    }
}
