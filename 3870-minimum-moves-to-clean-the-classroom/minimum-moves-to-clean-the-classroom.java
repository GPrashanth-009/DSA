import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = 0, startC = 0, litterCount = 0;
        int[][] litterIdx = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                litterIdx[i][j] = -1;
                char cell = classroom[i].charAt(j);
                if (cell == 'S') {
                    startR = i;
                    startC = j;
                } else if (cell == 'L') {
                    litterIdx[i][j] = litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;
        if (targetMask == 0) {
            return 0;
        }

        boolean[][][][] visited = new boolean[m][n][energy + 1][targetMask + 1];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startR, startC, energy, 0, 0});
        visited[startR][startC][energy][0] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            for (int i = 0; i < 4; i++) {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
                    char cell = classroom[nRow].charAt(nCol);

                    if (cell == 'X' || e == 0) {
                        continue;
                    }

                    int nextEnergy = e - 1;
                    int nextMask = mask;

                    if (cell == 'R') {
                        nextEnergy = energy;
                    } else if (cell == 'L' && litterIdx[nRow][nCol] != -1) {
                        nextMask |= (1 << litterIdx[nRow][nCol]);
                    }

                    if (nextMask == targetMask) {
                        return moves + 1;
                    }

                    if (!visited[nRow][nCol][nextEnergy][nextMask]) {
                        visited[nRow][nCol][nextEnergy][nextMask] = true;
                        q.offer(new int[]{nRow, nCol, nextEnergy, nextMask, moves + 1});
                    }
                }
            }
        }

        return -1;
    }
}
