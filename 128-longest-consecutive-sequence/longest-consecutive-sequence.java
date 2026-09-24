class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if (n == 0) {
            return 0;
        }
        // for (int i = 0; i < n - 1; i++) {
        // int minIndex = i;

        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[j] < nums[minIndex]) {
        //             minIndex = j;
        //         }
        //     }

        //     int temp = nums[i];
        //     nums[i] = nums[minIndex];
        //     nums[minIndex] = temp;
        // }
        Arrays.sort(nums);
        int c=1;
        int m=1;
        for(int i=0;i<n-1;i++){
            if((nums[i])!=nums[i+1]){
          
                if((nums[i]+1)==nums[i+1]){
                    c++;
                }
                else{
                    m=Math.max(m,c);
                    c=1;
                }
            }
        }
        return Math.max(m,c);
        
    }
}

