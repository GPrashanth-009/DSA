class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        
        int maxIdx = 0;
        int minIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }

        int left = Math.min(maxIdx, minIdx);
        int right = Math.max(maxIdx, minIdx);

        int bothFromFront = right + 1;
        int bothFromBack = n - left;
        int oneFromEachSide = (left + 1) + (n - right);

        return Math.min(bothFromFront, Math.min(bothFromBack, oneFromEachSide));
    }
}
