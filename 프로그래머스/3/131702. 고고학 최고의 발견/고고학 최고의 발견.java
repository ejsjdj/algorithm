

class Solution {
    int min;
    int n;
    int m;
    public int solution(int[][] clockHands) {
        min = Integer.MAX_VALUE;
        n = clockHands.length;;
        m = clockHands[0].length;
        dfs(0, clockHands, 0);
        return min;
    }

    void dfs(int col, int[][] board, int cnt) {
        if (col == board[0].length) {
            calc(board,cnt);
        } else {
            int n = board.length;
            int m = board[0].length;
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) System.arraycopy(board[i], 0, arr[i], 0, m);

            dfs(col + 1, arr, cnt);
            rotate(arr, 0, col, 1); dfs(col + 1, arr, cnt + 1);
            rotate(arr, 0, col, 1); dfs(col + 1, arr, cnt + 2);
            rotate(arr, 0, col, 1); dfs(col + 1, arr, cnt + 3);
        }
    }

    void calc(int[][] board, int cnt) {

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) System.arraycopy(board[i], 0, arr[i], 0, m);


        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (arr[r - 1][c] == 1) {
                    rotate(arr, r, c, 3);
                    cnt += 3;
                } else if (arr[r - 1][c] == 2) {
                    rotate(arr, r, c, 2);
                    cnt += 2;
                } else if (arr[r - 1][c] == 3) {
                    rotate(arr, r, c, 1);
                    cnt += 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (arr[n - 1][i] != 0) return;
        }
        min = Math.min(min, cnt);
    }

    void rotate (int[][] board, int r, int c, int k) {
        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, -1, 1, 0, 0};

        for (int i = 0; i < 5; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (0 <= nr && nr < board.length && 0 <= nc && nc < board[0].length) {
                board[nr][nc] = (board[nr][nc] + k) % 4;
            }
        }
    }

}