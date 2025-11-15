class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = n / w;
        
        if (n % w > 0) {
        	h += 1;
        }
        
        int[][] arr = new int[h][w];
         
        int row = h;
        int col = 0;
        
        boolean flag = false;
        
        int pos_col = 0;
        int pos_row = 0;
        
        for (int i = 0; i < n; i++) {
        	if (i % w == 0) {
        		row = row - 1;
        		flag = !flag;
        	} else {
        		if (flag) col += 1;
        		else col -= 1;        		
        	}
        	
        	arr[row][col] = i + 1;
        	
        	if (i + 1 == num) {
        		pos_col = col;
        		pos_row = row;
        	}
        	
        }
        for (int i = pos_row; i >= 0; i--) {
        	if (arr[i][pos_col] != 0) answer++;
        }
        return answer;
    }
}