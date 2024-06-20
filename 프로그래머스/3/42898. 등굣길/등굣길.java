class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] visited = new boolean[m+1][n+1];
        int[][] cnt = new int[m+1][n+1];
        
        for (int i = 0; i < puddles.length; i++) {
        	int x = puddles[i][0];
        	int y = puddles[i][1];
        	visited[x][y] = true;
        }
        visited[1][1] = true;
        
        for (int i = 0; i <= m; i++) {
        	for (int j = 0; j <= n; j++) {
        		cnt[i][j] = 0;
        	}
        }
        
        cnt[1][1] = 1;
        
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		if (!visited[j][i]) {
        			cnt[j][i] = (cnt[j-1][i] + cnt[j][i-1])% 1000000007;        			
        		}
        	}
        }
        
        return cnt[m][n];
    }
}