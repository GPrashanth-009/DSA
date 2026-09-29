class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        memo = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0, m, n);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal, int m, int n) {
        if (grid[r][c] == '(') {
            bal++;
        } else {
            bal--;
        }

        if (bal < 0 || bal >= m + n) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }

        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }

        boolean foundPath = false;

        if (c + 1 < n) {
            foundPath = foundPath || dfs(grid, r, c + 1, bal, m, n);
        }

        if (r + 1 < m) {
            foundPath = foundPath || dfs(grid, r + 1, c, bal, m, n);
        }

        return memo[r][c][bal] = foundPath;
    }
}
