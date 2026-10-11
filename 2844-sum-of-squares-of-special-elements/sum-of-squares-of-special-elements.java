class Solution {
    public int sumOfSquares(int[] nums) {

        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Convert 0-indexed 'i' to 1-indexed by adding 1
            int oneIndexed = i + 1;
            
            if (n % oneIndexed == 0) {
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
}
