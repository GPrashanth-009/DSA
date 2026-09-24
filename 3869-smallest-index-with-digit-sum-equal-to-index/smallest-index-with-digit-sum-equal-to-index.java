// class Solution {
//     public int smallestIndex(int[] nums) {
//         int n=nums.length;
        
//         for(int i=0;i<n;i++){
//            int ind=i;
//            int temp=nums[i];
//            int s=0;

//            while(temp>=0){
//             int k=temp%10;
//              s+=k;
//              temp=temp/10;


//             if(s==ind){
//                 return i;
//             }
//            }
//         }
//         return -1;
//     }
// }


class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];
            int sum = 0;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}