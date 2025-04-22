import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a, b) -> {
        	if (a[col - 1] != b[col - 1]) return a[col - 1] - b[col - 1];
        	return b[0] - a[0];
        });
        
        int[] S = new int[row_end - row_begin + 1];
        
        for (int i = row_begin; i <= row_end; i++) {
        	for (int j = 0; j < data[i-1].length; j++) {
        		S[i - row_begin] += data[i-1][j] % i;
        	}
        }
        
        for (int i = row_begin; i <= row_end; i++) {
        	answer = answer ^ S[i - row_begin];
        }
        
        return answer;
    }
}