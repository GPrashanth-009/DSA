
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLenSofar = new int[n];
        Arrays.fill(minLenSofar, Integer.MAX_VALUE);
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int runningSum = 0;
        int minTotalLength = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            runningSum += arr[r];
            map.put(runningSum, r);
            
            if (map.containsKey(runningSum - target)) {
                int l = map.get(runningSum - target);
                int currLen = r - l;
                currentMinLen = Math.min(currentMinLen, currLen);
                
                if (l >= 0 && minLenSofar[l] != Integer.MAX_VALUE) {
                    minTotalLength = Math.min(minTotalLength, currLen + minLenSofar[l]);
                }
            }
            minLenSofar[r] = currentMinLen;
        }
        
        return minTotalLength == Integer.MAX_VALUE ? -1 : minTotalLength;
    }
}
