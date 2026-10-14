class Solution {
    public String maxSumOfSquares(int num, int sum) {
        

        // If the required sum exceeds the maximum possible sum for 'num' digits
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int remainingSum = sum;

        for (int i = 0; i < num; i++) {
            int take = Math.min(9, remainingSum);
            sb.append(take);
            remainingSum -= take;
        }

        return sb.toString();
    }
}
