class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1;
         for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + (i % 2);
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (l <= lastEnd) {
                    break;
                }
                
                int length = r - l + 1;
                     if (length >= k) {
                    count++;
                    lastEnd = r; 
                    break; 
                }
                
                l--;
                r++;
            }    
        }
        
    return count;
    }
}