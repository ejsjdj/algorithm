class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] arr = new int[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
        		int a = results[i][0];
        		int b = results[i][1];
        		arr[a][b] = 1;
        		arr[b][a] = -1;
        }
        
        for (int k = 1; k < n + 1; k++) {
        		for (int i = 1; i < n + 1; i++) {
        			for (int j = 1; j < n + 1; j++) {
        				if (arr[i][k] > 0 && arr[k][j] > 0) {
        					arr[i][j] = 1;
        					arr[j][i] = -1;
        				}
        			}
        		}
        }
        for (int i = 1; i < n + 1; i++) {
        		boolean flag = true;
        		for (int j = 1; j < n + 1; j++) {
        			if (i == j) continue;
        			if (arr[i][j] == 0) flag = false;
        		}
        		if (flag) answer++;
        }
        
        return answer;
    }
}
