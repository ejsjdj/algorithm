class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;

        int[] matrix = new int[n + 1];
        matrix[0] = matrix_sizes[0][0];
        for (int i = 0; i < n; i++) {
            matrix[i + 1] = matrix_sizes[i][1];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + matrix[i] * matrix[k+1] * matrix[j+1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[0][n-1];
    }
}
