

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // totalCount includes the empty subsequence initially
        long totalCount = 1; 
        
        // Track the number of subsequences added by each lowercase letter
        long[] lastAddedCount = new long[26];
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            // The number of new subsequences this character can form
            long newSubsequences = totalCount;
            
            // Calculate the updated total count
            // We add newSubsequences and subtract the duplicates created previously by this same character
            long nextTotalCount = (totalCount * 2 - lastAddedCount[charIdx]) % MOD;
            
            // Handle negative values from the modulo operation in Java
            if (nextTotalCount < 0) {
                nextTotalCount += MOD;
            }
            
            // Update the rolling total and record what this character contributed
            totalCount = nextTotalCount;
            lastAddedCount[charIdx] = newSubsequences;
        }
        
        // Subtract 1 to remove the empty subsequence, as the problem requires non-empty subsequences
        return (int) ((totalCount - 1 + MOD) % MOD);
    }
}
