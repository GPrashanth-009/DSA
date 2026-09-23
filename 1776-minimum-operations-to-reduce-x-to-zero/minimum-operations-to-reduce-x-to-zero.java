class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;
        if (target < 0) return -1;
        if (target == 0) return n;


        int maxLen = -1;
        int currentSum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            currentSum += nums[r];

            while (currentSum > target && l <= r) {
                currentSum -= nums[l];
                l++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}