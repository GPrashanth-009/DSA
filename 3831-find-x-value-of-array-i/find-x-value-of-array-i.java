class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            nextDp[num % k]++;
            
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    // Fix: Cast 'r' to long to prevent integer overflow before modulo
                    int nextIdx = (int) (((long) r * num) % k);
                    nextDp[nextIdx] += dp[r];
                }
            }
            
            for (int r = 0; r < k; r++) {
                ans[r] += nextDp[r];
            }
            dp = nextDp;
        }
        
        return ans;
    }
}
