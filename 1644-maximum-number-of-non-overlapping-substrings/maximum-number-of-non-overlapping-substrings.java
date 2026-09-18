

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        // Step 1: Record the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        List<int[]> intervals = new ArrayList<>();
        
        // Step 2: Expand intervals to fulfill the containment conditions
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            int l = first[i];
            int r = last[i];
            boolean isValid = true;
            
            for (int j = l; j <= r; j++) {
                int c = s.charAt(j) - 'a';
                l = Math.min(l, first[c]);
                r = Math.max(r, last[c]);
                
                // If the left bound expands past the character's original start, 
                // this loop is redundant/invalid because it's a sub-segment of an earlier character's full span.
                if (l < first[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                intervals.add(new int[]{l, r});
            }
        }
        
        // Step 3: Sort intervals greedily by their end position
        Collections.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        List<String> result = new ArrayList<>();
        int lastEnd = -1;
        
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            
            // If the interval doesn't overlap with the last picked one
            if (l > lastEnd) {
                result.add(s.substring(l, r + 1));
                lastEnd = r;
            }
        }
        
        return result;
    }
}
