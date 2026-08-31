import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        
        List<Integer>[] graphs = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graphs[i] = new ArrayList<>();
            graphs[i].add(i);
        }
        
        for (int i = 0; i < edge_list.length; i++) {
            int u = edge_list[i][0];
            int v = edge_list[i][1];
            graphs[u].add(v);
            graphs[v].add(u);
        }
        
        int[][] dp = new int[k + 1][n + 1];
        
        for (int i = 0; i <= k; i ++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 10_000_000;
            }
        }
        
        dp[1][gps_log[0]] = 0;
        
        for (int i = 2; i <= k; i++) {
            
            int pos = gps_log[i-1];
            
            for (int j = 1; j <= n; j++) {
                if (dp[i - 1][j] == 10_000_000) continue;
                
                for (int next : graphs[j]) {
                    if (next == pos) dp[i][next] = Math.min(dp[i - 1][j], dp[i][next]);
                    else dp[i][next] = Math.min(dp[i - 1][j] + 1, dp[i][next]);
                }
                
            }
            
        }
        if (dp[k][gps_log[k-1]] == 10_000_000) answer = -1;
        else answer = dp[k][gps_log[k-1]];
        return answer;
    }
}