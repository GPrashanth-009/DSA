class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int needed = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (needed % 2 != 0) {
                    res++;
                    needed--;
                }
                needed += 2;
            } else {
                needed--;
                if (needed < 0) {
                    res++;
                    needed = 1;
                }
            }
        }
        
        return res + needed;
    }
}
