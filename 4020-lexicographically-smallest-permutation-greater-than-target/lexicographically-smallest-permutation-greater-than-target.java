class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] originalCnt = new int[26];
        for (int i = 0; i < n; i++) {
            originalCnt[s.charAt(i) - 'a']++;
        }

        int maxPrefixLen = -1;
        int choiceChar = -1;

        int[] currentCnt = new int[26];
        System.arraycopy(originalCnt, 0, currentCnt, 0, 26);

        for (int i = 0; i < n; i++) {
            int targetChar = target.charAt(i) - 'a';
            
            for (int j = targetChar + 1; j < 26; j++) {
                if (currentCnt[j] > 0) {
                    maxPrefixLen = i;
                    choiceChar = j;
                    break;
                }
            }

            if (currentCnt[targetChar] > 0) {
                currentCnt[targetChar]--;
            } else {
                break;
            }
        }

        if (maxPrefixLen == -1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        System.arraycopy(originalCnt, 0, cnt, 0, 26);

        for (int i = 0; i < maxPrefixLen; i++) {
            char c = target.charAt(i);
            sb.append(c);
            cnt[c - 'a']--;
        }

        sb.append((char) (choiceChar + 'a'));
        cnt[choiceChar]--;

        for (int j = 0; j < 26; j++) {
            while (cnt[j] > 0) {
                sb.append((char) (j + 'a'));
                cnt[j]--;
            }
        }

        return sb.toString();
    }
}
