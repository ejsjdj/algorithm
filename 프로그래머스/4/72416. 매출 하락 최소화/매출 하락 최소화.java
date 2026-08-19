import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[][] dp;
    int[] _sales;
    
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        _sales = new int[n+1];
        for(int i = 1; i <= n; i++) {
            _sales[i] = sales[i-1];
        }
        
        tree = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < links.length; i++) {
            tree[links[i][0]].add(links[i][1]);
        }
        
        dp = new int[n+1][2];   
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int cur) {
        dp[cur][1] = _sales[cur];
        
        if(tree[cur].size() == 0) return;
        
        int extraCost = Integer.MAX_VALUE; 
        boolean hasAttendingChild = false; 
        
        for(int child : tree[cur]) {
            dfs(child);
            
            dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
            
            dp[cur][0] += Math.min(dp[child][0], dp[child][1]);
            
            
            extraCost = Math.min(extraCost, dp[child][1] - dp[child][0]);
        }
        
        if(extraCost > 0) {
            dp[cur][0] += extraCost;
        }
    }
}