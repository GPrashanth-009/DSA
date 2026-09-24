class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if (n == 0) {
            return 0;
        }
        // Selection sort algorithm:

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

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;

//         Set<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }

//         int maxStreak = 0;

//         for (int num : set) {
//             // Check if this number is the absolute start of a sequence
//             if (!set.contains(num - 1)) {
//                 int currentNum = num;
//                 int currentStreak = 1;

//                 // Track the continuous sequence forward
//                 while (set.contains(currentNum + 1)) {
//                     currentNum += 1;
//                     currentStreak += 1;
//                 }

//                 maxStreak = Math.max(maxStreak, currentStreak);
//             }
//         }
//         return maxStreak;
//     }
// }
