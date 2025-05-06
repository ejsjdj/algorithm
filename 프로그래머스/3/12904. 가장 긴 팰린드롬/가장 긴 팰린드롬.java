class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        
        // 길이가 1인 모든 부분 문자열은 팰린드롬
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // 길이가 2인 부분 문자열 검사
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }
        
        // 길이가 3 이상인 부분 문자열 검사
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // 끝 인덱스
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = len;
                }
            }
        }
        
        return maxLength;
    }
}