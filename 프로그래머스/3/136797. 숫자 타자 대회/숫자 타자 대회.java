import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = Integer.MAX_VALUE;
        int[][] move = new int[10][10];
        int[][] DP = new int[numbers.length()][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) move[i][j] = 1;
                else {
                    int r1 = (i == 0) ? 3 : (i - 1) / 3;
                    int c1 = (i == 0) ? 1 : (i - 1) % 3;
                    int r2 = (j == 0) ? 3 : (j - 1) / 3;
                    int c2 = (j == 0) ? 1 : (j - 1) % 3;

                    int dr = Math.abs(r1 - r2);
                    int dc = Math.abs(c1 - c2);

                    move[i][j] = Math.min(dr, dc) * 3 + Math.abs(dr - dc) * 2;
                }
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            Arrays.fill(DP[i], Integer.MAX_VALUE / 2);
        }
        
        int first = numbers.charAt(0) - '0';
        DP[0][6] = move[4][first];
        DP[0][4] = move[6][first];
        
        for (int i = 1; i < numbers.length(); i++) {
            int now = numbers.charAt(i) - '0';
            int prev = numbers.charAt(i - 1) - '0';
            
            for (int k = 0; k < 10; k++) {
                if (DP[i - 1][k] >= Integer.MAX_VALUE / 2) continue;
                
                if (now != prev) {
                    DP[i][prev] = Math.min(DP[i][prev], DP[i - 1][k] + move[k][now]);    
                }
                
                if (now != k) {
                    DP[i][k] = Math.min(DP[i][k], DP[i - 1][k] + move[prev][now]);
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            answer = Math.min(answer, DP[numbers.length() - 1][i]);
        }
        
        return answer;
    }
}