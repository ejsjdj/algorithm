class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
    	
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int num = 1;
        
        
        
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < columns; j++) {
        		arr[i][j] = num++;
        	}
        }
        
        for (int i = 0; i < queries.length; i++) {
        	answer[i] = move(arr, queries[i]);
        }
        
        return answer;
    }
    
    int move(int[][] arr, int[] queries) {
    	int min = Integer.MAX_VALUE;
    	int row1 = queries[0] - 1;	// 1
    	int col1 = queries[1] - 1;	// 1
    	int row2 = queries[2] - 1;	// 2
    	int col2 = queries[3] - 1;	// 2
    	
    	int next = 0;
    	int last = arr[row1+1][col1];
    	
    	for (int i = col1; i < col2; i++) {
    		min = Math.min(min, arr[row1][i]);
    		next = arr[row1][i];
    		arr[row1][i] = last;
    		last = next;
    	}
    	for (int i = row1; i < row2; i++) {
    		min = Math.min(min, arr[i][col2]);
    		next = arr[i][col2];
    		arr[i][col2] = last;
    		last = next;
    	}
    	for (int i = col2; i > col1; i--) {
    		min = Math.min(min, arr[row2][i]);
    		next = arr[row2][i];
    		arr[row2][i] = last;
    		last = next;
    	}
    	for (int i = row2; i > row1; i--) {
    		min = Math.min(min, arr[i][col1]);
    		next = arr[i][col1];
    		arr[i][col1] = last;
    		last = next;
    	}
    	
    	return min;
    }
}