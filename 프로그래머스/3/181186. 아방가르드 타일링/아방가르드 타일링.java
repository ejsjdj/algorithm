class Solution {
    public int solution(int n) {
        long mod = 1_000_000_007;
        long[] dp = new long[Math.max(n + 1, 7)];
        
        dp[0] = 1; 
        dp[1] = 1;
        if (n >= 2) dp[2] = 3;
        if (n >= 3) dp[3] = 10;
        if (n >= 4) dp[4] = 23;
        if (n >= 5) dp[5] = 62; // 23 + 20 + 15 + 2 + 2
        if (n >= 6) dp[6] = 170; // 62 + 46 + 50 + 6 + 2 + 4
        
        
        for (int i = 7; i <= n; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2] + 6*dp[i-3] + dp[i-4] - dp[i-6] + mod) % mod;
        }
        
        return (int) dp[n];
    }
}
// 1 2 5 2 2 4